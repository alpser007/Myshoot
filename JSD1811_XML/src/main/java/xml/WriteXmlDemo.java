package xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * д��XML�ĵ�
 * @author Neils
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		/*
		 * ����XML�ĵ��Ĵ��²���
		 * 1:����һ��Document�����ʾ�հ��ĵ�
		 * 2:��Document����Ӹ�Ԫ��
		 * 3:����XML�Ľṹ�������Ԫ��
		 * 4:����XmlWriter
		 * 5:��Documentͨ��XmlWriterд�����γ�XML�ĵ�
		 */
		try {
			List<Emp> empList = new ArrayList<Emp>();
			empList.add(new Emp(1,"����",22,"��",5000));
			empList.add(new Emp(2,"����",23,"Ů",6000));
			empList.add(new Emp(3,"����",24,"��",7000));
			empList.add(new Emp(4,"����",25,"Ů",8000));
			empList.add(new Emp(5,"Ǯ��",26,"��",9000));
			
			//1
			Document doc = DocumentHelper.createDocument();
			
			/*
			 * 2
			 * Document�ṩ����Ӹ�Ԫ�صĲ���:
			 * Element addElement(String name)
			 * �÷����ķ���ֵΪElementʵ������ʾ��ӵĸ�Ԫ��
			 * �Ա����ǶԸ�Ԫ��������׷�Ӳ�����
			 * �÷���ֻ�ܵ���һ�Σ���Ϊһ���ĵ�ֻ������һ����
			 */
			Element root = doc.addElement("list");
			
			for(Emp emp : empList) {
				Element empEle = root.addElement("emp");
				
				Element nameEle = empEle.addElement("name");
				nameEle.addText(emp.getName());
				
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge()+"");
				
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary()+"");
				
				empEle.addAttribute("id", emp.getId()+"");
			}
			
			FileOutputStream fos
				= new FileOutputStream("myemp.xml");
			XMLWriter writer = new XMLWriter(fos,OutputFormat.createPrettyPrint());
			
			writer.write(doc);
			System.out.println("�ĵ�������!");
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}









