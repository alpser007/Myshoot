package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XML文档
 * @author ta
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		/*
		 * 解析XML的大致步骤
		 * 1:创建SAXReader
		 * 2:使用SAXReader读取xml文档
		 * 3:获取根元素
		 * 4:按照XML的结构从根元素开始逐级获取子元素以
		 *   达到遍历XML文档数据的目的
		 */
		try {
			//保存所有解析出来的员工信息
			List<Emp> empList = new ArrayList<Emp>();
			//1
			SAXReader reader = new SAXReader();
			//2
			Document doc = reader.read(new File("emplist.xml"));
			//3 获取根元素
			Element root = doc.getRootElement();
			/*
			 * Element类的每一个实例用于表示XML文档的一个元素
			 * 其提供了获取相关信息的一系列方法:
			 * String getName()
			 * 获取当前元素的名字(标签名)
			 * 
			 * String getText()
			 * 获取当前元素中间的文本(开始,结束标签中间的文本)
			 * 
			 * Element element(String name)
			 * 获取指定名字的子标签
			 * 
			 * List elements()
			 * 获取所有子标签
			 * 
			 * List elements(String name)
			 * 获取所有同名子标签
			 * 
			 */
			String ename = root.getName();
			System.out.println("根元素:"+ename);
			
			//获取根标签下的所有<emp>标签
			List<Element> list = root.elements("emp");
			System.out.println(list.size());
		
			for(Element empEle : list) {
				//获取员工姓名
				Element nameEle = empEle.element("name");
				String name = nameEle.getTextTrim();
				System.out.println(name);
				//获取年龄
				int age = Integer.parseInt(
					empEle.element("age").getTextTrim()
				);
				//获取性别
				String gender = empEle.elementText("gender");
				//获取工资
				int salary = Integer.parseInt(
					empEle.elementText("salary")	
				);
				//获取属性id
				int id = Integer.parseInt(
					empEle.attributeValue("id")
				);
				
				Emp emp = new Emp(id, name, age, gender, salary);
				empList.add(emp);
			}
			
			System.out.println("解析完毕!");
			for(Emp emp : empList) {
				System.out.println(emp);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}







