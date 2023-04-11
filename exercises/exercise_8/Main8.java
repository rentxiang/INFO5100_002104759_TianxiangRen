import org.json.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Main8 {
    private static final String XML_FILE = "books.xml";
    private static final String JSON_FILE = "books.json";

    public static void main(String[] args) {
        // Create sample data
        String xml = "<BookShelf>" +
                        "<Book>" +
                            "<title>Java Programming</title>" +
                            "<publishedYear>2021</publishedYear>" +
                            "<numberOfPages>300</numberOfPages>" +
                            "<authors>" +
                                "<author>John Doe</author>" +
                                "<author>Jane Doe</author>" +
                            "</authors>" +
                        "</Book>" +
                        "<Book>" +
                            "<title>Data Science</title>" +
                            "<publishedYear>2022</publishedYear>" +
                            "<numberOfPages>250</numberOfPages>" +
                            "<authors>" +
                                "<author>Bob Smith</author>" +
                            "</authors>" +
                        "</Book>" +
                        "<Book>" +
                            "<title>Algorithms</title>" +
                            "<publishedYear>2023</publishedYear>" +
                            "<numberOfPages>400</numberOfPages>" +
                            "<authors>" +
                                "<author>Alice Johnson</author>" +
                                "<author>Bob Johnson</author>" +
                            "</authors>" +
                        "</Book>" +
                    "</BookShelf>";

        String json = "{\n" +
                        "  \"BookShelf\": {\n" +
                        "    \"Book\": [\n" +
                        "      {\n" +
                        "        \"title\": \"Java Programming\",\n" +
                        "        \"publishedYear\": 2021,\n" +
                        "        \"numberOfPages\": 300,\n" +
                        "        \"authors\": [\n" +
                        "          \"John Doe\",\n" +
                        "          \"Jane Doe\"\n" +
                        "        ]\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"title\": \"Data Science\",\n" +
                        "        \"publishedYear\": 2022,\n" +
                        "        \"numberOfPages\": 250,\n" +
                        "        \"authors\": [\n" +
                        "          \"Bob Smith\"\n" +
                        "        ]\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"title\": \"Algorithms\",\n" +
                        "        \"publishedYear\": 2023,\n" +
                        "        \"numberOfPages\": 400,\n" +
                        "        \"authors\": [\n" +
                        "          \"Alice Johnson\",\n" +
                        "          \"Bob Johnson\"\n" +
                        "        ]\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}";

        try {
            // Parse XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));
            doc.getDocumentElement().normalize();
            NodeList bookNodes = doc.getElementsByTagName("Book");

            // Print parsed XML
            System.out.println("Parsed XML:");
            for (int i = 0; i < bookNodes.getLength(); i++) {
                Node bookNode = bookNodes.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    System.out.println("Title: " + bookElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Published Year: " + bookElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                    System.out.println("Number of Pages: " + bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent());
                    NodeList authorNodes = bookElement.getElementsByTagName("author");
                    System.out.print("Authors: ");
                    for (int j = 0; j < authorNodes.getLength(); j++) {
                    System.out.print(authorNodes.item(j).getTextContent());
                    if (j != authorNodes.getLength() - 1) {
                    System.out.print(", ");
                        }
                    }
                    System.out.println();
                }
            }

                    // Modify XML by adding a new book programmatically
            Element newBook = doc.createElement("Book");
            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode("Web Development"));
            Element publishedYear = doc.createElement("publishedYear");
            publishedYear.appendChild(doc.createTextNode("2024"));
            Element numberOfPages = doc.createElement("numberOfPages");
            numberOfPages.appendChild(doc.createTextNode("200"));
            Element authors = doc.createElement("authors");
            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("Emily Smith"));
            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("John Smith"));
            authors.appendChild(author1);
            authors.appendChild(author2);
            newBook.appendChild(title);
            newBook.appendChild(publishedYear);
            newBook.appendChild(numberOfPages);
            newBook.appendChild(authors);
            doc.getDocumentElement().appendChild(newBook);

            // Print modified XML
            System.out.println("\nModified XML:");
            NodeList bookNodesAfterAdd = doc.getElementsByTagName("Book");
            for (int i = 0; i < bookNodesAfterAdd.getLength(); i++) {
                Node bookNode = bookNodesAfterAdd.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    System.out.println("Title: " + bookElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Published Year: " + bookElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                    System.out.println("Number of Pages: " + bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent());
                    NodeList authorNodes = bookElement.getElementsByTagName("author");
                    System.out.print("Authors: ");
                    for (int j = 0; j < authorNodes.getLength(); j++) {
                        System.out.print(authorNodes.item(j).getTextContent());
                        if (j != authorNodes.getLength() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                }
            }

            // Parse JSON
            JSONObject jsonObj = new JSONObject(json);
            JSONObject bookShelfObj = jsonObj.getJSONObject("BookShelf");
            JSONArray bookArr = bookShelfObj.getJSONArray("Book");

            // Print parsed JSON
            System.out.println("\nParsed JSON:");
            for (int i = 0; i < bookArr.length(); i++) {
                JSONObject bookObj = bookArr.getJSONObject(i);
                System.out.println("Title: " + bookObj.getString("title"));
                System.out.println("Published Year: " + bookObj.getInt("publishedYear"));
                System.out.println("Number of Pages: " + bookObj.getInt("numberOfPages"));
                JSONArray authorArr = bookObj.getJSONArray("authors");
                System.out.print("Authors: ");
                for (int j = 0; j < authorArr.length(); j++) {
                    System.out.print(authorArr.getString(j));
                    if (j != authorArr.length() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }

        } catch (Exception e) {
        e.printStackTrace();
        }
    }
}


