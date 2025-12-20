/**
* Lead Author(s):
* @author mastahype; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-11-03
*/

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Purpose: The reponsibility of Sprite is ...
 *
 * Sprite is-a ...
 * Sprite is ...
 */
public class Sprite
{
	protected BufferedImage image;
	protected int x, y, width, height;
	protected Rectangle hitbox;
	
	protected Boolean isFlipped = false;
	
	private JSONObject jsonFile;
	protected Map<String, BufferedImage> frames;
	protected Map<String, String[]> animations;
	
	protected String curAnim;
	protected String[] curFrames;
	protected int curFrameNumber;
	
	private int curFPS;
	private int maxFPS;
	
	protected Boolean playingAnim = false;
	

	public Sprite(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void loadFromSheet(String path) {
		try
		{
			frames = new HashMap<String, BufferedImage>();
			animations = new HashMap<String, String[]>();		//setup animations Map for later use
			
			String content = Files.readString(new File(path + ".json").toPath()); //get string content from JSON file
			
			JSONObject json = new JSONObject(content); //create JSON object using the string content from the file
			jsonFile = json;		//set jsonFile variable to be used elsewhere
			
			JSONArray array = json.getJSONArray("frames");
			width = array.getJSONObject(0).getJSONObject("sourceSize").getInt("w");		//set width and height of the sprite
			height = array.getJSONObject(0).getJSONObject("sourceSize").getInt("h");
			
			image = ImageIO.read(new File(path + ".png"));		//get image
			
			for (int i = 0; i < array.length(); i++)
			{
				JSONObject frame = array.getJSONObject(i);
				
				//code to create the frame name (key) to point to their respective frame image
				String fileName = frame.getString("filename");
				StringBuilder fileNameBuilder = new StringBuilder(fileName);
				fileNameBuilder.delete(0, fileNameBuilder.indexOf("(")+1);		//remove the filename
				fileNameBuilder.deleteCharAt(fileNameBuilder.indexOf(")"));		//remove other parenthesis
				fileNameBuilder.delete(fileNameBuilder.indexOf("."), fileNameBuilder.length());		//remove .aseprite
				//System.out.println(fileNameBuilder);
				
				int frameX = frame.getJSONObject("frame").getInt("x");
				int frameY = frame.getJSONObject("frame").getInt("y");
				int frameW = frame.getJSONObject("frame").getInt("w");
				int frameH = frame.getJSONObject("frame").getInt("h");

				frames.put(fileNameBuilder.toString(), image.getSubimage(frameX, frameY, frameW, frameH));		//frameName -> BufferedImage
			}
			
			image = image.getSubimage(0, 0, width, height);		//set image as first frame to avoid displaying whole sheet
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFromImage(String path) {
		try
		{
			image = ImageIO.read(new File(path));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addAnimAtlas(String animName) {
		if (jsonFile == null) {
			System.out.println("JSON file is null");
			return;
		}
		
		JSONArray arr = jsonFile.getJSONObject("meta").getJSONArray("layers");		//get array of JSON file layers (animations)
		String animCatch = null;
		
		for (int i = 0; i < arr.length(); i++)
		{
			if (arr.getJSONObject(i).getString("name").matches(animName)) {		//checks if the given animName to be added was located
				animCatch = animName;
				break;
			}
		}
		if (animCatch == null) {
			System.out.println("Could not find animation with the name " + animName + " in JSON file");
			return;
		}
		
		ArrayList<String> animArray = new ArrayList<String>();
		for (Map.Entry<String, BufferedImage> entry : frames.entrySet())	//adds all frame names that share the name of animName
		{
			if (entry.getKey().contains(animName)) {
				animArray.add(entry.getKey());
			}
		}
		Collections.sort(animArray);	//sort frames in order (by number)

		String[] temp = {};
		animations.put(animName, animArray.toArray(temp));
	}
	
	public void addAnimIndices(String animName, String[] indices) {
		
	}
	
	public void playAnim(String animName, int fps) {
		if (!animations.containsKey(animName)) {
			System.out.println("No animation of name " + animName + " found. (Does it need to be added?)");
		}
		
		curAnim = animName;
		curFrames = animations.get(animName);
		playingAnim = true;
		if (!animName.matches(curAnim))
			curFrameNumber = 0;
		maxFPS = fps;
		curFPS = 0;
	}
	
	public void setFrame(String frameName) {
		if (frames.containsKey(frameName)) {
			image = frames.get(frameName);
			//curAnim = frameName;
			playingAnim = false;
		}
		else
			System.out.println("No frame exists with the name " + frameName);
	}
	
	public void flip() {
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		
		isFlipped = !isFlipped;
		System.out.println(isFlipped);
	}
	
	public void update(int UPS) {
		
		if (curFPS > maxFPS)
			curFPS = 0;
		if (playingAnim && curFPS == 0) {
			if (curFrameNumber > curFrames.length-1) {
				curFrameNumber = 0;
			}
			
			image = frames.get(curFrames[curFrameNumber]);
			if (isFlipped) {
				flip();
				isFlipped = true;
			}
			
			curFrameNumber++;
			
		}
		curFPS++;
		//System.out.println(isFlipped);
	}
	
	public BufferedImage getBufferedImage() {
		return image;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
