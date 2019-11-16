package com.netposa.isdalogupaliyun.springbootzhsq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/26 18:42
 *
 */
@Component
public class FileUtil {

	private static FileProperties fileProperties;

	private static Logger log = LoggerFactory.getLogger(FileUtil.class);

	private static File file;

	public FileUtil(FileProperties fileProperties) {
		this.fileProperties = fileProperties;
		file = new File(this.fileProperties.getLogUpAliyunLocal());
	}

	/**
	 * 按字符读取
	 * @return void
	 * @throws
	 * @author zhanglong
	 * @date 2019/6/26 18:43
	 */
	public static void readFileByChar() throws IOException {
		int num=0;
		char[] buf=new char[1024];
		//打开文件
		FileReader fr = new FileReader(file);
		//取出字符存到buf数组中
		while((num=fr.read(buf))!=-1) {
			//String(char[] cbuf,a,b),从cbuf的位置a开始取出连续的b个char组成字符串
			System.out.println(new String(buf,0,num));;
		}
		//检测一下是否取到相应的数据
		for(int i=0;i<10;i++) {
			System.out.print(buf[i]+" ");
		}
	}

	/**
	 * @description: 按行读取 //暂时用不到这个方法
	 * @return void
	 * @throws
	 * @author zhanglong
	 * @date 2019/6/26 18:44
	 */
//	public void readFileByLine() throws IOException {
//		int position=0;
//		String[] bufstring=new String[1024];
//		//打开带读取的文件
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		String line=null;
//		while((line=br.readLine())!=null) {
//			bufstring[position]=line;
//			position++;
//		}
//		br.close();//关闭文件
//		for(int i=0;i<position;i++) {
//			System.out.println(bufstring[i]);
//		}
//	}

	/**
	 * @description: 不换行写入
	 * @return void
	 * @throws
	 * @author zhanglong
	 * @date 2019/6/26 18:46
	 */
	public static void write(String str) throws IOException {
		log.info("file.length() : " + file.length());
		//FileOutputStream第二个参数默认false，如果是true，就在文件后面追加内容
		OutputStream os = new FileOutputStream(file,true);
		PrintWriter pw=new PrintWriter(os);
		//大于0说明有数据，需要先换行，再些数据
		if(file.length() > 0) {
			pw.println();
		}
		pw.write(str);
		pw.close();
		os.close();
	}

	/**
	 * @description: 自动换行写入
	 * @return void
	 * @throws
	 * @author zhanglong
	 * @date 2019/6/26 18:46
	 */
	public static void writeNewLine() throws IOException {
		log.info("file.length() : " + file.length());
		//FileOutputStream第二个参数默认false，如果是true，就在文件后面追加内容
		OutputStream os = new FileOutputStream(file,true);
		PrintWriter pw=new PrintWriter(os);
		pw.println("");
		pw.close();
		os.close();
	}

	/**
	 * @description: 按行读取，读取最后一行的数据
	 * @return void
	 * @throws
	 * @author zhanglong
	 * @date 2019/6/26 18:44
	 */
	public static String getEndLine() throws IOException {
		int position=0;
		String[] bufstring=new String[1024];
		//打开带读取的文件
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line=null;
		while((line=br.readLine())!=null) {
			bufstring[position]=line;
			position++;
		}
		br.close();//关闭文件
		return position > 0 ? bufstring[position-1] : null;
	}
}
