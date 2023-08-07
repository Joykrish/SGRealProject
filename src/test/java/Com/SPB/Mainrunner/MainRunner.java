package Com.SPB.Mainrunner;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class MainRunner {
	static TestNG testng;

	public static void main(String[] args) throws URISyntaxException {
	String fileName = "TestRun.xml";
	//String filepath = getClass().getClassLoader().getResource("brokenimage.xml").getFile();
		MainRunner app = new MainRunner();
		System.out.println(System.getProperty("user.dir"));
		testng = new TestNG();
		String path =System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH");
		path = path+"\\"+fileName;
		List<String> xmlList = new ArrayList<String>();
		String filePath =path;//app.getFileFromResourceAsStream(path);
		xmlList.add(filePath);
		testng.setTestSuites(xmlList);
		testng.run();

	}
	private String getFileFromResourceAsStream(String fileName) throws URISyntaxException {
		String path = getClass().getClassLoader().getResource(fileName).getFile();
		if (path == null) {
		throw new IllegalArgumentException("file not found! " + fileName);
		} else {
		return path;
		}



		}
}
