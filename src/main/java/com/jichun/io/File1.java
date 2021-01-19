package com.jichun.io;
import java.io.File;
import java.io.IOException;
public class File1 {
	
	
	public File1() {
	}
	
	/**
	 * 列出根目录
	 * 
	 * @author : xbm
	 * @date : 2019年4月19日 下午3:04:20
	 */
	public static void lsitRootFile(){
		File[] listRoots = File.listRoots();
		for(File file:listRoots){
			System.out.println(file.getPath()+"==="+file.getName());
		}
	}
	
	/**
	 * 
	 * @author  : xbm
	 * @date    : 2019年4月19日 下午2:34:37
	 */
	public static void listFileName(String folderName) {
		File folder = new File(folderName);
		// list()方法调用的必须是一个已经存在的目录
		String[] list = folder.list();
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	/**
	 * 遍历一个目录下的所有的文件
	 * 
	 * @param folder
	 *            目录的名称
	 * @author : xbm
	 * @date : 2019年4月19日 下午2:09:58
	 */
	public static void fileList(String folderName) {
		File folder = new File(folderName);
		// 列出该目录下的所有文件
		File[] listFiles = folder.listFiles();
		for (File file : listFiles) {
			/* 
			 * 输出文件的名称和文件的大小（byte)为单位，这个好像要是文件夹的话返回的文件夹大小不对
			 * 
			 */
			System.out.println(file.getName() + "===" + file.length());
		}
	}
	
	/**
	 * 判断是否是绝对路径
	 * 
	 * @param fileName
	 *            文件的名称
	 * @author : xbm
	 * @date : 2019年4月19日 上午11:07:31
	 */
	public static void isAbsolute(String fileName){
		File file = new File(fileName);
		boolean absolute = file.isAbsolute();
		System.out.println("是否绝对路径："+absolute);
	}
	
	/**
	 * 删除文件夹或者文件
	 * 
	 * @param file
	 *            删除的文件或者文件夹的名称
	 * @author : xbm
	 * @date : 2019年4月19日 上午9:32:51
	 */
	public static void deleteFile(String filename){
		File file  = new File(filename);
		file.delete();
	}
	
	
	/**
	 * 创建一个文件夹
	 * 
	 * @author : xbm
	 * @date : 2019年4月18日 下午8:27:39
	 * @param filename
	 *            要创建的文件夹的路径和名称，在Linux下用/隔开，在windows下用\\\\或者\\分隔
	 */
	public static void createFolder(String foldername) {
		File file = new File(foldername);
		file.mkdir();
	}
	
	/**
	 * 创建一个新的空文件
	 * 
	 * @param filename
	 *            文件的路径和名称
	 * 
	 * @throws IOException
	 *             I/O 异常
	 * @author : xbm
	 * @date : 2019年4月19日 上午9:16:32
	 * 
	 */
	public static void createFile(String filename) throws IOException{
		File file = new File(filename);
		file.createNewFile();
	}
}
