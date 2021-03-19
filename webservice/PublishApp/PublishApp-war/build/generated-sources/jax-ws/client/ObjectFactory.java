
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

    private final static QName _AddAddressToCustomer_QNAME = new QName("http://service/", "addAddressToCustomer");
    private final static QName _AddNewSubscription_QNAME = new QName("http://service/", "addNewSubscription");
    private final static QName _AddSubscriptionsToCustomers_QNAME = new QName("http://service/", "addSubscriptionsToCustomers");
    private final static QName _Address_QNAME = new QName("http://service/", "address");
    private final static QName _CreateCustomer_QNAME = new QName("http://service/", "createCustomer");
    private final static QName _Customer_QNAME = new QName("http://service/", "customer");
    private final static QName _FindSubscriptionsByTitle_QNAME = new QName("http://service/", "findSubscriptionsByTitle");
    private final static QName _FindSubscriptionsByTitleResponse_QNAME = new QName("http://service/", "findSubscriptionsByTitleResponse");
    private final static QName _GetAddressesOfCustomer_QNAME = new QName("http://service/", "getAddressesOfCustomer");
    private final static QName _GetAddressesOfCustomerResponse_QNAME = new QName("http://service/", "getAddressesOfCustomerResponse");
    private final static QName _GetAllCustomers_QNAME = new QName("http://service/", "getAllCustomers");
    private final static QName _GetAllCustomersResponse_QNAME = new QName("http://service/", "getAllCustomersResponse");
    private final static QName _GetAllSubscriptions_QNAME = new QName("http://service/", "getAllSubscriptions");
    private final static QName _GetAllSubscriptionsResponse_QNAME = new QName("http://service/", "getAllSubscriptionsResponse");
    private final static QName _GetCustomersByFirstName_QNAME = new QName("http://service/", "getCustomersByFirstName");
    private final static QName _GetCustomersByFirstNameResponse_QNAME = new QName("http://service/", "getCustomersByFirstNameResponse");
    private final static QName _GetCustomersByLastName_QNAME = new QName("http://service/", "getCustomersByLastName");
    private final static QName _GetCustomersByLastNameResponse_QNAME = new QName("http://service/", "getCustomersByLastNameResponse");
    private final static QName _GetCustomersOfTitle_QNAME = new QName("http://service/", "getCustomersOfTitle");
    private final static QName _GetCustomersOfTitleResponse_QNAME = new QName("http://service/", "getCustomersOfTitleResponse");
    private final static QName _GetSubscriptionsOfCustomer_QNAME = new QName("http://service/", "getSubscriptionsOfCustomer");
    private final static QName _GetSubscriptionsOfCustomerResponse_QNAME = new QName("http://service/", "getSubscriptionsOfCustomerResponse");
    private final static QName _RemoveAddressFromCustomer_QNAME = new QName("http://service/", "removeAddressFromCustomer");
    private final static QName _RemoveCustomer_QNAME = new QName("http://service/", "removeCustomer");
    private final static QName _RemoveSubscription_QNAME = new QName("http://service/", "removeSubscription");
    private final static QName _RemoveSubscriptionsFromCustomers_QNAME = new QName("http://service/", "removeSubscriptionsFromCustomers");
    private final static QName _Subscription_QNAME = new QName("http://service/", "subscription");
    private final static QName _UpdateCustomer_QNAME = new QName("http://service/", "updateCustomer");
    private final static QName _UpdateSubscription_QNAME = new QName("http://service/", "updateSubscription");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddAddressToCustomer }
     * 
     */
    public AddAddressToCustomer createAddAddressToCustomer() {
        return new AddAddressToCustomer();
    }

    /**
     * Create an instance of {@link AddNewSubscription }
     * 
     */
    public AddNewSubscription createAddNewSubscription() {
        return new AddNewSubscription();
    }

    /**
     * Create an instance of {@link AddSubscriptionsToCustomers }
     * 
     */
    public AddSubscriptionsToCustomers createAddSubscriptionsToCustomers() {
        return new AddSubscriptionsToCustomers();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link CreateCustomer }
     * 
     */
    public CreateCustomer createCreateCustomer() {
        return new CreateCustomer();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link FindSubscriptionsByTitle }
     * 
     */
    public FindSubscriptionsByTitle createFindSubscriptionsByTitle() {
        return new FindSubscriptionsByTitle();
    }

    /**
     * Create an instance of {@link FindSubscriptionsByTitleResponse }
     * 
     */
    public FindSubscriptionsByTitleResponse createFindSubscriptionsByTitleResponse() {
        return new FindSubscriptionsByTitleResponse();
    }

    /**
     * Create an instance of {@link GetAddressesOfCustomer }
     * 
     */
    public GetAddressesOfCustomer createGetAddressesOfCustomer() {
        return new GetAddressesOfCustomer();
    }

    /**
     * Create an instance of {@link GetAddressesOfCustomerResponse }
     * 
     */
    public GetAddressesOfCustomerResponse createGetAddressesOfCustomerResponse() {
        return new GetAddressesOfCustomerResponse();
    }

    /**
     * Create an instance of {@link GetAllCustomers }
     * 
     */
    public GetAllCustomers createGetAllCustomers() {
        return new GetAllCustomers();
    }

    /**
     * Create an instance of {@link GetAllCustomersResponse }
     * 
     */
    public GetAllCustomersResponse createGetAllCustomersResponse() {
        return new GetAllCustomersResponse();
    }

    /**
     * Create an instance of {@link GetAllSubscriptions }
     * 
     */
    public GetAllSubscriptions createGetAllSubscriptions() {
        return new GetAllSubscriptions();
    }

    /**
     * Create an instance of {@link GetAllSubscriptionsResponse }
     * 
     */
    public GetAllSubscriptionsResponse createGetAllSubscriptionsResponse() {
        return new GetAllSubscriptionsResponse();
    }

    /**
     * Create an instance of {@link GetCustomersByFirstName }
     * 
     */
    public GetCustomersByFirstName createGetCustomersByFirstName() {
        return new GetCustomersByFirstName();
    }

    /**
     * Create an instance of {@link GetCustomersByFirstNameResponse }
     * 
     */
    public GetCustomersByFirstNameResponse createGetCustomersByFirstNameResponse() {
        return new GetCustomersByFirstNameResponse();
    }

    /**
     * Create an instance of {@link GetCustomersByLastName }
     * 
     */
    public GetCustomersByLastName createGetCustomersByLastName() {
        return new GetCustomersByLastName();
    }

    /**
     * Create an instance of {@link GetCustomersByLastNameResponse }
     * 
     */
    public GetCustomersByLastNameResponse createGetCustomersByLastNameResponse() {
        return new GetCustomersByLastNameResponse();
    }

    /**
     * Create an instance of {@link GetCustomersOfTitle }
     * 
     */
    public GetCustomersOfTitle createGetCustomersOfTitle() {
        return new GetCustomersOfTitle();
    }

    /**
     * Create an instance of {@link GetCustomersOfTitleResponse }
     * 
     */
    public GetCustomersOfTitleResponse createGetCustomersOfTitleResponse() {
        return new GetCustomersOfTitleResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsOfCustomer }
     * 
     */
    public GetSubscriptionsOfCustomer createGetSubscriptionsOfCustomer() {
        return new GetSubscriptionsOfCustomer();
    }

    /**
     * Create an instance of {@link GetSubscriptionsOfCustomerResponse }
     * 
     */
    public GetSubscriptionsOfCustomerResponse createGetSubscriptionsOfCustomerResponse() {
        return new GetSubscriptionsOfCustomerResponse();
    }

    /**
     * Create an instance of {@link RemoveAddressFromCustomer }
     * 
     */
    public RemoveAddressFromCustomer createRemoveAddressFromCustomer() {
        return new RemoveAddressFromCustomer();
    }

    /**
     * Create an instance of {@link RemoveCustomer }
     * 
     */
    public RemoveCustomer createRemoveCustomer() {
        return new RemoveCustomer();
    }

    /**
     * Create an instance of {@link RemoveSubscription }
     * 
     */
    public RemoveSubscription createRemoveSubscription() {
        return new RemoveSubscription();
    }

    /**
     * Create an instance of {@link RemoveSubscriptionsFromCustomers }
     * 
     */
    public RemoveSubscriptionsFromCustomers createRemoveSubscriptionsFromCustomers() {
        return new RemoveSubscriptionsFromCustomers();
    }

    /**
     * Create an instance of {@link Subscription }
     * 
     */
    public Subscription createSubscription() {
        return new Subscription();
    }

    /**
     * Create an instance of {@link UpdateCustomer }
     * 
     */
    public UpdateCustomer createUpdateCustomer() {
        return new UpdateCustomer();
    }

    /**
     * Create an instance of {@link UpdateSubscription }
     * 
     */
    public UpdateSubscription createUpdateSubscription() {
        return new UpdateSubscription();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAddressToCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddAddressToCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "addAddressToCustomer")
    public JAXBElement<AddAddressToCustomer> createAddAddressToCustomer(AddAddressToCustomer value) {
        return new JAXBElement<AddAddressToCustomer>(_AddAddressToCustomer_QNAME, AddAddressToCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewSubscription }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddNewSubscription }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "addNewSubscription")
    public JAXBElement<AddNewSubscription> createAddNewSubscription(AddNewSubscription value) {
        return new JAXBElement<AddNewSubscription>(_AddNewSubscription_QNAME, AddNewSubscription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSubscriptionsToCustomers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddSubscriptionsToCustomers }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "addSubscriptionsToCustomers")
    public JAXBElement<AddSubscriptionsToCustomers> createAddSubscriptionsToCustomers(AddSubscriptionsToCustomers value) {
        return new JAXBElement<AddSubscriptionsToCustomers>(_AddSubscriptionsToCustomers_QNAME, AddSubscriptionsToCustomers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Address }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "createCustomer")
    public JAXBElement<CreateCustomer> createCreateCustomer(CreateCustomer value) {
        return new JAXBElement<CreateCustomer>(_CreateCustomer_QNAME, CreateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSubscriptionsByTitle }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindSubscriptionsByTitle }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "findSubscriptionsByTitle")
    public JAXBElement<FindSubscriptionsByTitle> createFindSubscriptionsByTitle(FindSubscriptionsByTitle value) {
        return new JAXBElement<FindSubscriptionsByTitle>(_FindSubscriptionsByTitle_QNAME, FindSubscriptionsByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSubscriptionsByTitleResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindSubscriptionsByTitleResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "findSubscriptionsByTitleResponse")
    public JAXBElement<FindSubscriptionsByTitleResponse> createFindSubscriptionsByTitleResponse(FindSubscriptionsByTitleResponse value) {
        return new JAXBElement<FindSubscriptionsByTitleResponse>(_FindSubscriptionsByTitleResponse_QNAME, FindSubscriptionsByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddressesOfCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAddressesOfCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAddressesOfCustomer")
    public JAXBElement<GetAddressesOfCustomer> createGetAddressesOfCustomer(GetAddressesOfCustomer value) {
        return new JAXBElement<GetAddressesOfCustomer>(_GetAddressesOfCustomer_QNAME, GetAddressesOfCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddressesOfCustomerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAddressesOfCustomerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAddressesOfCustomerResponse")
    public JAXBElement<GetAddressesOfCustomerResponse> createGetAddressesOfCustomerResponse(GetAddressesOfCustomerResponse value) {
        return new JAXBElement<GetAddressesOfCustomerResponse>(_GetAddressesOfCustomerResponse_QNAME, GetAddressesOfCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCustomers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllCustomers }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllCustomers")
    public JAXBElement<GetAllCustomers> createGetAllCustomers(GetAllCustomers value) {
        return new JAXBElement<GetAllCustomers>(_GetAllCustomers_QNAME, GetAllCustomers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCustomersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllCustomersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllCustomersResponse")
    public JAXBElement<GetAllCustomersResponse> createGetAllCustomersResponse(GetAllCustomersResponse value) {
        return new JAXBElement<GetAllCustomersResponse>(_GetAllCustomersResponse_QNAME, GetAllCustomersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSubscriptions }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllSubscriptions }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllSubscriptions")
    public JAXBElement<GetAllSubscriptions> createGetAllSubscriptions(GetAllSubscriptions value) {
        return new JAXBElement<GetAllSubscriptions>(_GetAllSubscriptions_QNAME, GetAllSubscriptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSubscriptionsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllSubscriptionsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllSubscriptionsResponse")
    public JAXBElement<GetAllSubscriptionsResponse> createGetAllSubscriptionsResponse(GetAllSubscriptionsResponse value) {
        return new JAXBElement<GetAllSubscriptionsResponse>(_GetAllSubscriptionsResponse_QNAME, GetAllSubscriptionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomersByFirstName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomersByFirstName }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCustomersByFirstName")
    public JAXBElement<GetCustomersByFirstName> createGetCustomersByFirstName(GetCustomersByFirstName value) {
        return new JAXBElement<GetCustomersByFirstName>(_GetCustomersByFirstName_QNAME, GetCustomersByFirstName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomersByFirstNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomersByFirstNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCustomersByFirstNameResponse")
    public JAXBElement<GetCustomersByFirstNameResponse> createGetCustomersByFirstNameResponse(GetCustomersByFirstNameResponse value) {
        return new JAXBElement<GetCustomersByFirstNameResponse>(_GetCustomersByFirstNameResponse_QNAME, GetCustomersByFirstNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomersByLastName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomersByLastName }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCustomersByLastName")
    public JAXBElement<GetCustomersByLastName> createGetCustomersByLastName(GetCustomersByLastName value) {
        return new JAXBElement<GetCustomersByLastName>(_GetCustomersByLastName_QNAME, GetCustomersByLastName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomersByLastNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomersByLastNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCustomersByLastNameResponse")
    public JAXBElement<GetCustomersByLastNameResponse> createGetCustomersByLastNameResponse(GetCustomersByLastNameResponse value) {
        return new JAXBElement<GetCustomersByLastNameResponse>(_GetCustomersByLastNameResponse_QNAME, GetCustomersByLastNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomersOfTitle }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomersOfTitle }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCustomersOfTitle")
    public JAXBElement<GetCustomersOfTitle> createGetCustomersOfTitle(GetCustomersOfTitle value) {
        return new JAXBElement<GetCustomersOfTitle>(_GetCustomersOfTitle_QNAME, GetCustomersOfTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomersOfTitleResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomersOfTitleResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCustomersOfTitleResponse")
    public JAXBElement<GetCustomersOfTitleResponse> createGetCustomersOfTitleResponse(GetCustomersOfTitleResponse value) {
        return new JAXBElement<GetCustomersOfTitleResponse>(_GetCustomersOfTitleResponse_QNAME, GetCustomersOfTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsOfCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsOfCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getSubscriptionsOfCustomer")
    public JAXBElement<GetSubscriptionsOfCustomer> createGetSubscriptionsOfCustomer(GetSubscriptionsOfCustomer value) {
        return new JAXBElement<GetSubscriptionsOfCustomer>(_GetSubscriptionsOfCustomer_QNAME, GetSubscriptionsOfCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsOfCustomerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsOfCustomerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "getSubscriptionsOfCustomerResponse")
    public JAXBElement<GetSubscriptionsOfCustomerResponse> createGetSubscriptionsOfCustomerResponse(GetSubscriptionsOfCustomerResponse value) {
        return new JAXBElement<GetSubscriptionsOfCustomerResponse>(_GetSubscriptionsOfCustomerResponse_QNAME, GetSubscriptionsOfCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAddressFromCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveAddressFromCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "removeAddressFromCustomer")
    public JAXBElement<RemoveAddressFromCustomer> createRemoveAddressFromCustomer(RemoveAddressFromCustomer value) {
        return new JAXBElement<RemoveAddressFromCustomer>(_RemoveAddressFromCustomer_QNAME, RemoveAddressFromCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "removeCustomer")
    public JAXBElement<RemoveCustomer> createRemoveCustomer(RemoveCustomer value) {
        return new JAXBElement<RemoveCustomer>(_RemoveCustomer_QNAME, RemoveCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSubscription }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveSubscription }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "removeSubscription")
    public JAXBElement<RemoveSubscription> createRemoveSubscription(RemoveSubscription value) {
        return new JAXBElement<RemoveSubscription>(_RemoveSubscription_QNAME, RemoveSubscription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSubscriptionsFromCustomers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveSubscriptionsFromCustomers }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "removeSubscriptionsFromCustomers")
    public JAXBElement<RemoveSubscriptionsFromCustomers> createRemoveSubscriptionsFromCustomers(RemoveSubscriptionsFromCustomers value) {
        return new JAXBElement<RemoveSubscriptionsFromCustomers>(_RemoveSubscriptionsFromCustomers_QNAME, RemoveSubscriptionsFromCustomers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subscription }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Subscription }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "subscription")
    public JAXBElement<Subscription> createSubscription(Subscription value) {
        return new JAXBElement<Subscription>(_Subscription_QNAME, Subscription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateCustomer")
    public JAXBElement<UpdateCustomer> createUpdateCustomer(UpdateCustomer value) {
        return new JAXBElement<UpdateCustomer>(_UpdateCustomer_QNAME, UpdateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSubscription }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateSubscription }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateSubscription")
    public JAXBElement<UpdateSubscription> createUpdateSubscription(UpdateSubscription value) {
        return new JAXBElement<UpdateSubscription>(_UpdateSubscription_QNAME, UpdateSubscription.class, null, value);
    }

}
