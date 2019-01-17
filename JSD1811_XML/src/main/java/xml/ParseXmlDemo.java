package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��DOM����XML�ĵ�
 * @author ta
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		/*
		 * ����XML�Ĵ��²���
		 * 1:����SAXReader
		 * 2:ʹ��SAXReader��ȡxml�ĵ�
		 * 3:��ȡ��Ԫ��
		 * 4:����XML�Ľṹ�Ӹ�Ԫ�ؿ�ʼ�𼶻�ȡ��Ԫ����
		 *   �ﵽ����XML�ĵ����ݵ�Ŀ��
		 */
		try {
			//�������н���������Ա����Ϣ
			List<Emp> empList = new ArrayList<Emp>();
			//1
			SAXReader reader = new SAXReader();
			//2
			Document doc = reader.read(new File("emplist.xml"));
			//3 ��ȡ��Ԫ��
			Element root = doc.getRootElement();
			/*
			 * Element���ÿһ��ʵ�����ڱ�ʾXML�ĵ���һ��Ԫ��
			 * ���ṩ�˻�ȡ�����Ϣ��һϵ�з���:
			 * String getName()
			 * ��ȡ��ǰԪ�ص�����(��ǩ��)
			 * 
			 * String getText()
			 * ��ȡ��ǰԪ���м���ı�(��ʼ,������ǩ�м���ı�)
			 * 
			 * Element element(String name)
			 * ��ȡָ�����ֵ��ӱ�ǩ
			 * 
			 * List elements()
			 * ��ȡ�����ӱ�ǩ
			 * 
			 * List elements(String name)
			 * ��ȡ����ͬ���ӱ�ǩ
			 * 
			 */
			String ename = root.getName();
			System.out.println("��Ԫ��:"+ename);
			
			//��ȡ����ǩ�µ�����<emp>��ǩ
			List<Element> list = root.elements("emp");
			System.out.println(list.size());
		
			for(Element empEle : list) {
				//��ȡԱ������
				Element nameEle = empEle.element("name");
				String name = nameEle.getTextTrim();
				System.out.println(name);
				//��ȡ����
				int age = Integer.parseInt(
					empEle.element("age").getTextTrim()
				);
				//��ȡ�Ա�
				String gender = empEle.elementText("gender");
				//��ȡ����
				int salary = Integer.parseInt(
					empEle.elementText("salary")	
				);
				//��ȡ����id
				int id = Integer.parseInt(
					empEle.attributeValue("id")
				);
				
				Emp emp = new Emp(id, name, age, gender, salary);
				empList.add(emp);
			}
			
			System.out.println("�������!");
			for(Emp emp : empList) {
				System.out.println(emp);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}







