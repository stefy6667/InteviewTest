import Service.DuplicateLetter;
import Service.FizzBuzz;


public class Runner {


    public static void main(String[] args) throws Exception {

//
//        // Add new user
//        User user = new User();
//        user.setFirstName("First Name2");
//        user.setLastName("Last Name2");
//        user.setEmail("Email2");
//        user.setPhoneNumber("0752787361");
//        user.setDate(LocalDate.now());
//
//        UserService service = new UserService();
//        //service.createUser(user);
//           service.GetX(0);
//        //service.getUserByID(1);
//
//        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
//                .newInstance();
//        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
//        Document document = docBuilder.parse(new File("/home/andrei/GeomantTest/src/main/resources/example.xml"));
//
//        NodeList nodeList = document.getElementsByTagName("*");
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Node node = nodeList.item(i);
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                // do something with the current element
//                System.out.print(node.getTextContent());
//            }
//        }
        FizzBuzz fizzBuzz =new FizzBuzz();
        //fizzBuzz.FizzBuzz(5);
        DuplicateLetter dup =new DuplicateLetter();
        dup.DuplicateLetter("alma");

    }
}
