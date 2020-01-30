
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHelloResponse_QNAME = new QName("http://svc.webage.com/", "sayHelloResponse");
    private final static QName _Training_QNAME = new QName("http://svc.webage.com/", "training");
    private final static QName _GetTrainingClass_QNAME = new QName("http://svc.webage.com/", "getTrainingClass");
    private final static QName _GetTrainingClassResponse_QNAME = new QName("http://svc.webage.com/", "getTrainingClassResponse");
    private final static QName _SayHello_QNAME = new QName("http://svc.webage.com/", "sayHello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link Course }
     * 
     */
    public Course createCourse() {
        return new Course();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link GetTrainingClassResponse }
     * 
     */
    public GetTrainingClassResponse createGetTrainingClassResponse() {
        return new GetTrainingClassResponse();
    }

    /**
     * Create an instance of {@link GetTrainingClass }
     * 
     */
    public GetTrainingClass createGetTrainingClass() {
        return new GetTrainingClass();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://svc.webage.com/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Course }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://svc.webage.com/", name = "training")
    public JAXBElement<Course> createTraining(Course value) {
        return new JAXBElement<Course>(_Training_QNAME, Course.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTrainingClass }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://svc.webage.com/", name = "getTrainingClass")
    public JAXBElement<GetTrainingClass> createGetTrainingClass(GetTrainingClass value) {
        return new JAXBElement<GetTrainingClass>(_GetTrainingClass_QNAME, GetTrainingClass.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTrainingClassResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://svc.webage.com/", name = "getTrainingClassResponse")
    public JAXBElement<GetTrainingClassResponse> createGetTrainingClassResponse(GetTrainingClassResponse value) {
        return new JAXBElement<GetTrainingClassResponse>(_GetTrainingClassResponse_QNAME, GetTrainingClassResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://svc.webage.com/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

}
