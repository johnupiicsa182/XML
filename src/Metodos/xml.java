package Metodos;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


public class xml {
	public Document crear(String name,String job,Integer salary) {
		Document document=null;
		try {
			//Crear documento
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			document=builder.newDocument();
			//Crear elementos
			Element compania=document.createElement("compania");
			document.appendChild(compania);
			Element empleados=document.createElement("empleados");
			compania.appendChild(empleados);
			Attr attr=document.createAttribute("id");
			Integer n=1;
			attr.setValue(n.toString());
			n++;
			empleados.setAttributeNode(attr);
			//Crear el contenido
			Element nombre=document.createElement("nombre");
			nombre.appendChild(document.createTextNode(name));
			empleados.appendChild(nombre);
			Element puesto=document.createElement("Puesto");
			puesto.appendChild(document.createTextNode(job));
			empleados.appendChild(puesto);
			Element sueldo=document.createElement("sueldo");
			sueldo.appendChild(document.createTextNode(salary.toString()));
			empleados.appendChild(sueldo);
			//Escribir los datos en el archivo
			TransformerFactory transformerFactory=TransformerFactory.newInstance();
			Transformer transformer=transformerFactory.newTransformer();
			DOMSource source=new DOMSource(document);
			StreamResult result=new StreamResult(new File("./archivo.xml"));
			transformer.transform(source,result);
			System.out.println("File saved!");
		}catch (Exception e) {
			System.out.println(e);
		}
		return document;
	}

}

