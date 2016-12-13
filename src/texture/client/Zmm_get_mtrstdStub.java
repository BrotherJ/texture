
/**
 * Zmm_get_mtrstdStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */
        package texture.client;

        

        /*
        *  Zmm_get_mtrstdStub java implementation
        */

        
        public class Zmm_get_mtrstdStub extends org.apache.axis2.client.Stub
        {
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return Long.toString(System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("Zmm_get_mtrstd" + getUniqueSuffix());
//     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZmmGetMtrstd"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         


    }

    /**
      *Constructor that takes in a configContext
      */

    public Zmm_get_mtrstdStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public Zmm_get_mtrstdStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
	
        configurationContext = _serviceClient.getServiceContext().getConfigurationContext();

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
    
    }

    /**
     * Default Constructor
     */
    public Zmm_get_mtrstdStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zmm_get_mtrstd/800/zmm_get_mtrstd/zmm_get_mtrstd" );
                
    }

    /**
     * Default Constructor
     */
    public Zmm_get_mtrstdStub() throws org.apache.axis2.AxisFault {
        
                    this("http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zmm_get_mtrstd/800/zmm_get_mtrstd/zmm_get_mtrstd" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public Zmm_get_mtrstdStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see Zmm_get_mtrstd#ZmmGetMtrstd
                     * @param zmmGetMtrstd0
                    
                     */

                    

                            public  Zmm_get_mtrstdStub.ZmmGetMtrstdResponse ZmmGetMtrstd(

                            Zmm_get_mtrstdStub.ZmmGetMtrstd zmmGetMtrstd0)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("\"\"");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    zmmGetMtrstd0,
                                                    optimizeContent(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style",
                                                    "ZmmGetMtrstd")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             Zmm_get_mtrstdStub.ZmmGetMtrstdResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (Zmm_get_mtrstdStub.ZmmGetMtrstdResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see Zmm_get_mtrstd#startZmmGetMtrstd
                    * @param zmmGetMtrstd0
                
                */
                public  void startZmmGetMtrstd(

                 Zmm_get_mtrstdStub.ZmmGetMtrstd zmmGetMtrstd0,

                  final Zmm_get_mtrstdCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("\"\"");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    zmmGetMtrstd0,
                                                    optimizeContent(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style",
                                                    "ZmmGetMtrstd")));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         Zmm_get_mtrstdStub.ZmmGetMtrstdResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultZmmGetMtrstd(
                                        (Zmm_get_mtrstdStub.ZmmGetMtrstdResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorZmmGetMtrstd(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorZmmGetMtrstd(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZmmGetMtrstd(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZmmGetMtrstd(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZmmGetMtrstd(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZmmGetMtrstd(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZmmGetMtrstd(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZmmGetMtrstd(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZmmGetMtrstd(f);
                                            }
									    } else {
										    callback.receiveErrorZmmGetMtrstd(f);
									    }
									} else {
									    callback.receiveErrorZmmGetMtrstd(f);
									}
								} else {
								    callback.receiveErrorZmmGetMtrstd(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorZmmGetMtrstd(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zmm_get_mtrstd/800/zmm_get_mtrstd/zmm_get_mtrstd
        public static class Char1
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char1",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char1
                        */

                        
                                    protected java.lang.String localChar1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar1(){
                               return localChar1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char1
                               */
                               public void setChar1(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 1)  ) {
                                                this.localChar1=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar1.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Char1.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":char1",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char1",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar1==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar1);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar1)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char1 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char1 returnValue = new  Char1();
                    
                            returnValue.setChar1(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char1 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char1.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char1.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char1 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char1 object =
                new Char1();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChar1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Char21
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char21",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char21
                        */

                        
                                    protected java.lang.String localChar21 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar21(){
                               return localChar21;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char21
                               */
                               public void setChar21(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 21)  ) {
                                                this.localChar21=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar21.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Char21.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":char21",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char21",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar21==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar21);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar21)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char21 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char21 returnValue = new  Char21();
                    
                            returnValue.setChar21(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char21 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char21.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char21.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char21 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char21 object =
                new Char21();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChar21(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class ZmmGetMtrstdResponse
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:soap:functions:mc-style",
                "ZmmGetMtrstdResponse",
                "ns2");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:soap:functions:mc-style")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for TCaizhi
                        */

                        
                                    protected TableOfZzcaizhi localTCaizhi ;
                                

                           /**
                           * Auto generated getter method
                           * @return TableOfZzcaizhi
                           */
                           public  TableOfZzcaizhi getTCaizhi(){
                               return localTCaizhi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TCaizhi
                               */
                               public void setTCaizhi(TableOfZzcaizhi param){
                            
                                            this.localTCaizhi=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       ZmmGetMtrstdResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:soap:functions:mc-style");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ZmmGetMtrstdResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZmmGetMtrstdResponse",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localTCaizhi==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TCaizhi cannot be null!!");
                                            }
                                           localTCaizhi.serialize(new javax.xml.namespace.QName("","TCaizhi"),
                                               factory,xmlWriter);
                                        
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TCaizhi"));
                            
                            
                                    if (localTCaizhi==null){
                                         throw new org.apache.axis2.databinding.ADBException("TCaizhi cannot be null!!");
                                    }
                                    elementList.add(localTCaizhi);
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ZmmGetMtrstdResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZmmGetMtrstdResponse object =
                new ZmmGetMtrstdResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"ZmmGetMtrstdResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZmmGetMtrstdResponse)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TCaizhi").equals(reader.getName())){
                                
                                                object.setTCaizhi(TableOfZzcaizhi.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                              
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Char20
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char20",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char20
                        */

                        
                                    protected java.lang.String localChar20 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar20(){
                               return localChar20;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char20
                               */
                               public void setChar20(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 20)  ) {
                                                this.localChar20=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar20.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Char20.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":char20",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char20",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar20==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar20);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar20)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char20 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char20 returnValue = new  Char20();
                    
                            returnValue.setChar20(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char20 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char20.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char20.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char20 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char20 object =
                new Char20();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChar20(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class ZmmGetMtrstd
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:soap:functions:mc-style",
                "ZmmGetMtrstd",
                "ns2");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:soap:functions:mc-style")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Std
                        */

                        
                                    protected Char1 localStd ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getStd(){
                               return localStd;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Std
                               */
                               public void setStd(Char1 param){
                            
                                            this.localStd=param;
                                    

                               }
                            

                        /**
                        * field for TCaizhi
                        */

                        
                                    protected TableOfZzcaizhi localTCaizhi ;
                                

                           /**
                           * Auto generated getter method
                           * @return TableOfZzcaizhi
                           */
                           public  TableOfZzcaizhi getTCaizhi(){
                               return localTCaizhi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TCaizhi
                               */
                               public void setTCaizhi(TableOfZzcaizhi param){
                            
                                            this.localTCaizhi=param;
                                    

                               }
                            

                        /**
                        * field for ZczNw
                        */

                        
                                    protected Char25 localZczNw ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getZczNw(){
                               return localZczNw;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZczNw
                               */
                               public void setZczNw(Char25 param){
                            
                                            this.localZczNw=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       ZmmGetMtrstd.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:soap:functions:mc-style");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ZmmGetMtrstd",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZmmGetMtrstd",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localStd==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Std cannot be null!!");
                                            }
                                           localStd.serialize(new javax.xml.namespace.QName("","Std"),
                                               factory,xmlWriter);
                                        
                                            if (localTCaizhi==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TCaizhi cannot be null!!");
                                            }
                                           localTCaizhi.serialize(new javax.xml.namespace.QName("","TCaizhi"),
                                               factory,xmlWriter);
                                        
                                            if (localZczNw==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZczNw cannot be null!!");
                                            }
                                           localZczNw.serialize(new javax.xml.namespace.QName("","ZczNw"),
                                               factory,xmlWriter);
                                        
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Std"));
                            
                            
                                    if (localStd==null){
                                         throw new org.apache.axis2.databinding.ADBException("Std cannot be null!!");
                                    }
                                    elementList.add(localStd);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TCaizhi"));
                            
                            
                                    if (localTCaizhi==null){
                                         throw new org.apache.axis2.databinding.ADBException("TCaizhi cannot be null!!");
                                    }
                                    elementList.add(localTCaizhi);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZczNw"));
                            
                            
                                    if (localZczNw==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZczNw cannot be null!!");
                                    }
                                    elementList.add(localZczNw);
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ZmmGetMtrstd parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZmmGetMtrstd object =
                new ZmmGetMtrstd();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"ZmmGetMtrstd".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZmmGetMtrstd)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Std").equals(reader.getName())){
                                
                                                object.setStd(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TCaizhi").equals(reader.getName())){
                                
                                                object.setTCaizhi(TableOfZzcaizhi.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZczNw").equals(reader.getName())){
                                
                                                object.setZczNw(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                              
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Zzcaizhi
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = Zzcaizhi
                Namespace URI = urn:sap-com:document:sap:soap:functions:mc-style
                Namespace Prefix = ns2
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:soap:functions:mc-style")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Mandt
                        */

                        
                                    protected Clnt3 localMandt ;
                                

                           /**
                           * Auto generated getter method
                           * @return Clnt3
                           */
                           public  Clnt3 getMandt(){
                               return localMandt;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Mandt
                               */
                               public void setMandt(Clnt3 param){
                            
                                            this.localMandt=param;
                                    

                               }
                            

                        /**
                        * field for Zcz
                        */

                        
                                    protected Char25 localZcz ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getZcz(){
                               return localZcz;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Zcz
                               */
                               public void setZcz(Char25 param){
                            
                                            this.localZcz=param;
                                    

                               }
                            

                        /**
                        * field for Vbeln
                        */

                        
                                    protected Char10 localVbeln ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char10
                           */
                           public  Char10 getVbeln(){
                               return localVbeln;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Vbeln
                               */
                               public void setVbeln(Char10 param){
                            
                                            this.localVbeln=param;
                                    

                               }
                            

                        /**
                        * field for Posnr
                        */

                        
                                    protected Numeric6 localPosnr ;
                                

                           /**
                           * Auto generated getter method
                           * @return Numeric6
                           */
                           public  Numeric6 getPosnr(){
                               return localPosnr;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Posnr
                               */
                               public void setPosnr(Numeric6 param){
                            
                                            this.localPosnr=param;
                                    

                               }
                            

                        /**
                        * field for Std
                        */

                        
                                    protected Char1 localStd ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getStd(){
                               return localStd;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Std
                               */
                               public void setStd(Char1 param){
                            
                                            this.localStd=param;
                                    

                               }
                            

                        /**
                        * field for Specificate
                        */

                        
                                    protected Char40 localSpecificate ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char40
                           */
                           public  Char40 getSpecificate(){
                               return localSpecificate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Specificate
                               */
                               public void setSpecificate(Char40 param){
                            
                                            this.localSpecificate=param;
                                    

                               }
                            

                        /**
                        * field for Ce
                        */

                        
                                    protected Char2 localCe ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char2
                           */
                           public  Char2 getCe(){
                               return localCe;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ce
                               */
                               public void setCe(Char2 param){
                            
                                            this.localCe=param;
                                    

                               }
                            

                        /**
                        * field for Pren
                        */

                        
                                    protected Char2 localPren ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char2
                           */
                           public  Char2 getPren(){
                               return localPren;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Pren
                               */
                               public void setPren(Char2 param){
                            
                                            this.localPren=param;
                                    

                               }
                            

                        /**
                        * field for Zdel
                        */

                        
                                    protected Char1 localZdel ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getZdel(){
                               return localZdel;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Zdel
                               */
                               public void setZdel(Char1 param){
                            
                                            this.localZdel=param;
                                    

                               }
                            

                        /**
                        * field for Cdate
                        */

                        
                                    protected Date10 localCdate ;
                                

                           /**
                           * Auto generated getter method
                           * @return Date10
                           */
                           public  Date10 getCdate(){
                               return localCdate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cdate
                               */
                               public void setCdate(Date10 param){
                            
                                            this.localCdate=param;
                                    

                               }
                            

                        /**
                        * field for Mdate
                        */

                        
                                    protected Date10 localMdate ;
                                

                           /**
                           * Auto generated getter method
                           * @return Date10
                           */
                           public  Date10 getMdate(){
                               return localMdate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Mdate
                               */
                               public void setMdate(Date10 param){
                            
                                            this.localMdate=param;
                                    

                               }
                            

                        /**
                        * field for Cuser
                        */

                        
                                    protected Char20 localCuser ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getCuser(){
                               return localCuser;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cuser
                               */
                               public void setCuser(Char20 param){
                            
                                            this.localCuser=param;
                                    

                               }
                            

                        /**
                        * field for Muser
                        */

                        
                                    protected Char20 localMuser ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getMuser(){
                               return localMuser;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Muser
                               */
                               public void setMuser(Char20 param){
                            
                                            this.localMuser=param;
                                    

                               }
                            

                        /**
                        * field for CMin
                        */

                        
                                    protected Quantum183 localCMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCMin(){
                               return localCMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CMin
                               */
                               public void setCMin(Quantum183 param){
                            
                                            this.localCMin=param;
                                    

                               }
                            

                        /**
                        * field for CMax
                        */

                        
                                    protected Quantum183 localCMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCMax(){
                               return localCMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CMax
                               */
                               public void setCMax(Quantum183 param){
                            
                                            this.localCMax=param;
                                    

                               }
                            

                        /**
                        * field for SiMin
                        */

                        
                                    protected Quantum183 localSiMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getSiMin(){
                               return localSiMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SiMin
                               */
                               public void setSiMin(Quantum183 param){
                            
                                            this.localSiMin=param;
                                    

                               }
                            

                        /**
                        * field for SiMax
                        */

                        
                                    protected Quantum183 localSiMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getSiMax(){
                               return localSiMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SiMax
                               */
                               public void setSiMax(Quantum183 param){
                            
                                            this.localSiMax=param;
                                    

                               }
                            

                        /**
                        * field for MnMin
                        */

                        
                                    protected Quantum183 localMnMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getMnMin(){
                               return localMnMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MnMin
                               */
                               public void setMnMin(Quantum183 param){
                            
                                            this.localMnMin=param;
                                    

                               }
                            

                        /**
                        * field for MnMax
                        */

                        
                                    protected Quantum183 localMnMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getMnMax(){
                               return localMnMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MnMax
                               */
                               public void setMnMax(Quantum183 param){
                            
                                            this.localMnMax=param;
                                    

                               }
                            

                        /**
                        * field for PMin
                        */

                        
                                    protected Quantum183 localPMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getPMin(){
                               return localPMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PMin
                               */
                               public void setPMin(Quantum183 param){
                            
                                            this.localPMin=param;
                                    

                               }
                            

                        /**
                        * field for PMax
                        */

                        
                                    protected Quantum183 localPMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getPMax(){
                               return localPMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PMax
                               */
                               public void setPMax(Quantum183 param){
                            
                                            this.localPMax=param;
                                    

                               }
                            

                        /**
                        * field for SMin
                        */

                        
                                    protected Quantum183 localSMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getSMin(){
                               return localSMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SMin
                               */
                               public void setSMin(Quantum183 param){
                            
                                            this.localSMin=param;
                                    

                               }
                            

                        /**
                        * field for SMax
                        */

                        
                                    protected Quantum183 localSMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getSMax(){
                               return localSMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SMax
                               */
                               public void setSMax(Quantum183 param){
                            
                                            this.localSMax=param;
                                    

                               }
                            

                        /**
                        * field for CrMin
                        */

                        
                                    protected Quantum183 localCrMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCrMin(){
                               return localCrMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CrMin
                               */
                               public void setCrMin(Quantum183 param){
                            
                                            this.localCrMin=param;
                                    

                               }
                            

                        /**
                        * field for CrMax
                        */

                        
                                    protected Quantum183 localCrMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCrMax(){
                               return localCrMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CrMax
                               */
                               public void setCrMax(Quantum183 param){
                            
                                            this.localCrMax=param;
                                    

                               }
                            

                        /**
                        * field for NiMin
                        */

                        
                                    protected Quantum183 localNiMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getNiMin(){
                               return localNiMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NiMin
                               */
                               public void setNiMin(Quantum183 param){
                            
                                            this.localNiMin=param;
                                    

                               }
                            

                        /**
                        * field for NiMax
                        */

                        
                                    protected Quantum183 localNiMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getNiMax(){
                               return localNiMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NiMax
                               */
                               public void setNiMax(Quantum183 param){
                            
                                            this.localNiMax=param;
                                    

                               }
                            

                        /**
                        * field for CuMin
                        */

                        
                                    protected Quantum183 localCuMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCuMin(){
                               return localCuMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CuMin
                               */
                               public void setCuMin(Quantum183 param){
                            
                                            this.localCuMin=param;
                                    

                               }
                            

                        /**
                        * field for CuMax
                        */

                        
                                    protected Quantum183 localCuMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCuMax(){
                               return localCuMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CuMax
                               */
                               public void setCuMax(Quantum183 param){
                            
                                            this.localCuMax=param;
                                    

                               }
                            

                        /**
                        * field for ZrMin
                        */

                        
                                    protected Quantum183 localZrMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZrMin(){
                               return localZrMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZrMin
                               */
                               public void setZrMin(Quantum183 param){
                            
                                            this.localZrMin=param;
                                    

                               }
                            

                        /**
                        * field for ZrMax
                        */

                        
                                    protected Quantum183 localZrMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZrMax(){
                               return localZrMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZrMax
                               */
                               public void setZrMax(Quantum183 param){
                            
                                            this.localZrMax=param;
                                    

                               }
                            

                        /**
                        * field for SnMin
                        */

                        
                                    protected Quantum183 localSnMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getSnMin(){
                               return localSnMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SnMin
                               */
                               public void setSnMin(Quantum183 param){
                            
                                            this.localSnMin=param;
                                    

                               }
                            

                        /**
                        * field for SnMax
                        */

                        
                                    protected Quantum183 localSnMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getSnMax(){
                               return localSnMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SnMax
                               */
                               public void setSnMax(Quantum183 param){
                            
                                            this.localSnMax=param;
                                    

                               }
                            

                        /**
                        * field for PbMin
                        */

                        
                                    protected Quantum183 localPbMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getPbMin(){
                               return localPbMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PbMin
                               */
                               public void setPbMin(Quantum183 param){
                            
                                            this.localPbMin=param;
                                    

                               }
                            

                        /**
                        * field for PbMax
                        */

                        
                                    protected Quantum183 localPbMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getPbMax(){
                               return localPbMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PbMax
                               */
                               public void setPbMax(Quantum183 param){
                            
                                            this.localPbMax=param;
                                    

                               }
                            

                        /**
                        * field for SbMin
                        */

                        
                                    protected Quantum183 localSbMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getSbMin(){
                               return localSbMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SbMin
                               */
                               public void setSbMin(Quantum183 param){
                            
                                            this.localSbMin=param;
                                    

                               }
                            

                        /**
                        * field for SbMax
                        */

                        
                                    protected Quantum183 localSbMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getSbMax(){
                               return localSbMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SbMax
                               */
                               public void setSbMax(Quantum183 param){
                            
                                            this.localSbMax=param;
                                    

                               }
                            

                        /**
                        * field for AsMin
                        */

                        
                                    protected Quantum183 localAsMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getAsMin(){
                               return localAsMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AsMin
                               */
                               public void setAsMin(Quantum183 param){
                            
                                            this.localAsMin=param;
                                    

                               }
                            

                        /**
                        * field for AsMax
                        */

                        
                                    protected Quantum183 localAsMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getAsMax(){
                               return localAsMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AsMax
                               */
                               public void setAsMax(Quantum183 param){
                            
                                            this.localAsMax=param;
                                    

                               }
                            

                        /**
                        * field for CoMin
                        */

                        
                                    protected Quantum183 localCoMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCoMin(){
                               return localCoMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CoMin
                               */
                               public void setCoMin(Quantum183 param){
                            
                                            this.localCoMin=param;
                                    

                               }
                            

                        /**
                        * field for CoMax
                        */

                        
                                    protected Quantum183 localCoMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCoMax(){
                               return localCoMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CoMax
                               */
                               public void setCoMax(Quantum183 param){
                            
                                            this.localCoMax=param;
                                    

                               }
                            

                        /**
                        * field for TaMin
                        */

                        
                                    protected Quantum183 localTaMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getTaMin(){
                               return localTaMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TaMin
                               */
                               public void setTaMin(Quantum183 param){
                            
                                            this.localTaMin=param;
                                    

                               }
                            

                        /**
                        * field for TaMax
                        */

                        
                                    protected Quantum183 localTaMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getTaMax(){
                               return localTaMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TaMax
                               */
                               public void setTaMax(Quantum183 param){
                            
                                            this.localTaMax=param;
                                    

                               }
                            

                        /**
                        * field for Ta1Min
                        */

                        
                                    protected Quantum183 localTa1Min ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getTa1Min(){
                               return localTa1Min;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ta1Min
                               */
                               public void setTa1Min(Quantum183 param){
                            
                                            this.localTa1Min=param;
                                    

                               }
                            

                        /**
                        * field for Ta1Max
                        */

                        
                                    protected Quantum183 localTa1Max ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getTa1Max(){
                               return localTa1Max;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ta1Max
                               */
                               public void setTa1Max(Quantum183 param){
                            
                                            this.localTa1Max=param;
                                    

                               }
                            

                        /**
                        * field for User1Min
                        */

                        
                                    protected Quantum183 localUser1Min ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getUser1Min(){
                               return localUser1Min;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param User1Min
                               */
                               public void setUser1Min(Quantum183 param){
                            
                                            this.localUser1Min=param;
                                    

                               }
                            

                        /**
                        * field for User1Max
                        */

                        
                                    protected Quantum183 localUser1Max ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getUser1Max(){
                               return localUser1Max;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param User1Max
                               */
                               public void setUser1Max(Quantum183 param){
                            
                                            this.localUser1Max=param;
                                    

                               }
                            

                        /**
                        * field for User2Min
                        */

                        
                                    protected Quantum183 localUser2Min ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getUser2Min(){
                               return localUser2Min;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param User2Min
                               */
                               public void setUser2Min(Quantum183 param){
                            
                                            this.localUser2Min=param;
                                    

                               }
                            

                        /**
                        * field for User2Max
                        */

                        
                                    protected Quantum183 localUser2Max ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getUser2Max(){
                               return localUser2Max;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param User2Max
                               */
                               public void setUser2Max(Quantum183 param){
                            
                                            this.localUser2Max=param;
                                    

                               }
                            

                        /**
                        * field for User3Min
                        */

                        
                                    protected Quantum183 localUser3Min ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getUser3Min(){
                               return localUser3Min;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param User3Min
                               */
                               public void setUser3Min(Quantum183 param){
                            
                                            this.localUser3Min=param;
                                    

                               }
                            

                        /**
                        * field for User3Max
                        */

                        
                                    protected Quantum183 localUser3Max ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getUser3Max(){
                               return localUser3Max;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param User3Max
                               */
                               public void setUser3Max(Quantum183 param){
                            
                                            this.localUser3Max=param;
                                    

                               }
                            

                        /**
                        * field for TsMin
                        */

                        
                                    protected Quantum183 localTsMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getTsMin(){
                               return localTsMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TsMin
                               */
                               public void setTsMin(Quantum183 param){
                            
                                            this.localTsMin=param;
                                    

                               }
                            

                        /**
                        * field for TsMax
                        */

                        
                                    protected Quantum183 localTsMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getTsMax(){
                               return localTsMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TsMax
                               */
                               public void setTsMax(Quantum183 param){
                            
                                            this.localTsMax=param;
                                    

                               }
                            

                        /**
                        * field for YsMin
                        */

                        
                                    protected Quantum183 localYsMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getYsMin(){
                               return localYsMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param YsMin
                               */
                               public void setYsMin(Quantum183 param){
                            
                                            this.localYsMin=param;
                                    

                               }
                            

                        /**
                        * field for YsMax
                        */

                        
                                    protected Quantum183 localYsMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getYsMax(){
                               return localYsMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param YsMax
                               */
                               public void setYsMax(Quantum183 param){
                            
                                            this.localYsMax=param;
                                    

                               }
                            

                        /**
                        * field for EMin
                        */

                        
                                    protected Quantum183 localEMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getEMin(){
                               return localEMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EMin
                               */
                               public void setEMin(Quantum183 param){
                            
                                            this.localEMin=param;
                                    

                               }
                            

                        /**
                        * field for EMax
                        */

                        
                                    protected Quantum183 localEMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getEMax(){
                               return localEMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EMax
                               */
                               public void setEMax(Quantum183 param){
                            
                                            this.localEMax=param;
                                    

                               }
                            

                        /**
                        * field for RMin
                        */

                        
                                    protected Quantum183 localRMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getRMin(){
                               return localRMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RMin
                               */
                               public void setRMin(Quantum183 param){
                            
                                            this.localRMin=param;
                                    

                               }
                            

                        /**
                        * field for RMax
                        */

                        
                                    protected Quantum183 localRMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getRMax(){
                               return localRMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RMax
                               */
                               public void setRMax(Quantum183 param){
                            
                                            this.localRMax=param;
                                    

                               }
                            

                        /**
                        * field for HbMin
                        */

                        
                                    protected Quantum183 localHbMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getHbMin(){
                               return localHbMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HbMin
                               */
                               public void setHbMin(Quantum183 param){
                            
                                            this.localHbMin=param;
                                    

                               }
                            

                        /**
                        * field for HbMax
                        */

                        
                                    protected Quantum183 localHbMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getHbMax(){
                               return localHbMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HbMax
                               */
                               public void setHbMax(Quantum183 param){
                            
                                            this.localHbMax=param;
                                    

                               }
                            

                        /**
                        * field for BMax
                        */

                        
                                    protected Quantum184 localBMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum184
                           */
                           public  Quantum184 getBMax(){
                               return localBMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BMax
                               */
                               public void setBMax(Quantum184 param){
                            
                                            this.localBMax=param;
                                    

                               }
                            

                        /**
                        * field for BMin
                        */

                        
                                    protected Quantum184 localBMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum184
                           */
                           public  Quantum184 getBMin(){
                               return localBMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BMin
                               */
                               public void setBMin(Quantum184 param){
                            
                                            this.localBMin=param;
                                    

                               }
                            

                        /**
                        * field for Heat1
                        */

                        
                                    protected Char40 localHeat1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char40
                           */
                           public  Char40 getHeat1(){
                               return localHeat1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Heat1
                               */
                               public void setHeat1(Char40 param){
                            
                                            this.localHeat1=param;
                                    

                               }
                            

                        /**
                        * field for Hdsc1
                        */

                        
                                    protected Char20 localHdsc1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHdsc1(){
                               return localHdsc1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hdsc1
                               */
                               public void setHdsc1(Char20 param){
                            
                                            this.localHdsc1=param;
                                    

                               }
                            

                        /**
                        * field for Temp1
                        */

                        
                                    protected Char15 localTemp1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getTemp1(){
                               return localTemp1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Temp1
                               */
                               public void setTemp1(Char15 param){
                            
                                            this.localTemp1=param;
                                    

                               }
                            

                        /**
                        * field for Tdsc1
                        */

                        
                                    protected Char20 localTdsc1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getTdsc1(){
                               return localTdsc1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Tdsc1
                               */
                               public void setTdsc1(Char20 param){
                            
                                            this.localTdsc1=param;
                                    

                               }
                            

                        /**
                        * field for Hold1
                        */

                        
                                    protected Char20 localHold1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHold1(){
                               return localHold1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hold1
                               */
                               public void setHold1(Char20 param){
                            
                                            this.localHold1=param;
                                    

                               }
                            

                        /**
                        * field for Hodsc1
                        */

                        
                                    protected Char20 localHodsc1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHodsc1(){
                               return localHodsc1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hodsc1
                               */
                               public void setHodsc1(Char20 param){
                            
                                            this.localHodsc1=param;
                                    

                               }
                            

                        /**
                        * field for Cool1
                        */

                        
                                    protected Char21 localCool1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char21
                           */
                           public  Char21 getCool1(){
                               return localCool1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cool1
                               */
                               public void setCool1(Char21 param){
                            
                                            this.localCool1=param;
                                    

                               }
                            

                        /**
                        * field for Cdsc1
                        */

                        
                                    protected Char20 localCdsc1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getCdsc1(){
                               return localCdsc1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cdsc1
                               */
                               public void setCdsc1(Char20 param){
                            
                                            this.localCdsc1=param;
                                    

                               }
                            

                        /**
                        * field for Furn1
                        */

                        
                                    protected Char20 localFurn1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getFurn1(){
                               return localFurn1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Furn1
                               */
                               public void setFurn1(Char20 param){
                            
                                            this.localFurn1=param;
                                    

                               }
                            

                        /**
                        * field for Fdsc1
                        */

                        
                                    protected Char20 localFdsc1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getFdsc1(){
                               return localFdsc1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fdsc1
                               */
                               public void setFdsc1(Char20 param){
                            
                                            this.localFdsc1=param;
                                    

                               }
                            

                        /**
                        * field for Heat2
                        */

                        
                                    protected Char40 localHeat2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char40
                           */
                           public  Char40 getHeat2(){
                               return localHeat2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Heat2
                               */
                               public void setHeat2(Char40 param){
                            
                                            this.localHeat2=param;
                                    

                               }
                            

                        /**
                        * field for Hdsc2
                        */

                        
                                    protected Char20 localHdsc2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHdsc2(){
                               return localHdsc2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hdsc2
                               */
                               public void setHdsc2(Char20 param){
                            
                                            this.localHdsc2=param;
                                    

                               }
                            

                        /**
                        * field for Temp2
                        */

                        
                                    protected Char15 localTemp2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getTemp2(){
                               return localTemp2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Temp2
                               */
                               public void setTemp2(Char15 param){
                            
                                            this.localTemp2=param;
                                    

                               }
                            

                        /**
                        * field for Tdsc2
                        */

                        
                                    protected Char20 localTdsc2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getTdsc2(){
                               return localTdsc2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Tdsc2
                               */
                               public void setTdsc2(Char20 param){
                            
                                            this.localTdsc2=param;
                                    

                               }
                            

                        /**
                        * field for Hold2
                        */

                        
                                    protected Char20 localHold2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHold2(){
                               return localHold2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hold2
                               */
                               public void setHold2(Char20 param){
                            
                                            this.localHold2=param;
                                    

                               }
                            

                        /**
                        * field for Hodsc2
                        */

                        
                                    protected Char20 localHodsc2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHodsc2(){
                               return localHodsc2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hodsc2
                               */
                               public void setHodsc2(Char20 param){
                            
                                            this.localHodsc2=param;
                                    

                               }
                            

                        /**
                        * field for Cool2
                        */

                        
                                    protected Char21 localCool2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char21
                           */
                           public  Char21 getCool2(){
                               return localCool2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cool2
                               */
                               public void setCool2(Char21 param){
                            
                                            this.localCool2=param;
                                    

                               }
                            

                        /**
                        * field for Cdsc2
                        */

                        
                                    protected Char20 localCdsc2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getCdsc2(){
                               return localCdsc2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cdsc2
                               */
                               public void setCdsc2(Char20 param){
                            
                                            this.localCdsc2=param;
                                    

                               }
                            

                        /**
                        * field for Furn2
                        */

                        
                                    protected Char20 localFurn2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getFurn2(){
                               return localFurn2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Furn2
                               */
                               public void setFurn2(Char20 param){
                            
                                            this.localFurn2=param;
                                    

                               }
                            

                        /**
                        * field for Fdsc2
                        */

                        
                                    protected Char20 localFdsc2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getFdsc2(){
                               return localFdsc2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fdsc2
                               */
                               public void setFdsc2(Char20 param){
                            
                                            this.localFdsc2=param;
                                    

                               }
                            

                        /**
                        * field for Heat3
                        */

                        
                                    protected Char40 localHeat3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char40
                           */
                           public  Char40 getHeat3(){
                               return localHeat3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Heat3
                               */
                               public void setHeat3(Char40 param){
                            
                                            this.localHeat3=param;
                                    

                               }
                            

                        /**
                        * field for Hdsc3
                        */

                        
                                    protected Char20 localHdsc3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHdsc3(){
                               return localHdsc3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hdsc3
                               */
                               public void setHdsc3(Char20 param){
                            
                                            this.localHdsc3=param;
                                    

                               }
                            

                        /**
                        * field for Temp3
                        */

                        
                                    protected Char15 localTemp3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getTemp3(){
                               return localTemp3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Temp3
                               */
                               public void setTemp3(Char15 param){
                            
                                            this.localTemp3=param;
                                    

                               }
                            

                        /**
                        * field for Tdsc3
                        */

                        
                                    protected Char20 localTdsc3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getTdsc3(){
                               return localTdsc3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Tdsc3
                               */
                               public void setTdsc3(Char20 param){
                            
                                            this.localTdsc3=param;
                                    

                               }
                            

                        /**
                        * field for Hold3
                        */

                        
                                    protected Char20 localHold3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHold3(){
                               return localHold3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hold3
                               */
                               public void setHold3(Char20 param){
                            
                                            this.localHold3=param;
                                    

                               }
                            

                        /**
                        * field for Hodsc3
                        */

                        
                                    protected Char20 localHodsc3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHodsc3(){
                               return localHodsc3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hodsc3
                               */
                               public void setHodsc3(Char20 param){
                            
                                            this.localHodsc3=param;
                                    

                               }
                            

                        /**
                        * field for Cool3
                        */

                        
                                    protected Char21 localCool3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char21
                           */
                           public  Char21 getCool3(){
                               return localCool3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cool3
                               */
                               public void setCool3(Char21 param){
                            
                                            this.localCool3=param;
                                    

                               }
                            

                        /**
                        * field for Cdsc3
                        */

                        
                                    protected Char20 localCdsc3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getCdsc3(){
                               return localCdsc3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cdsc3
                               */
                               public void setCdsc3(Char20 param){
                            
                                            this.localCdsc3=param;
                                    

                               }
                            

                        /**
                        * field for Furn3
                        */

                        
                                    protected Char20 localFurn3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getFurn3(){
                               return localFurn3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Furn3
                               */
                               public void setFurn3(Char20 param){
                            
                                            this.localFurn3=param;
                                    

                               }
                            

                        /**
                        * field for Fdsc3
                        */

                        
                                    protected Char20 localFdsc3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getFdsc3(){
                               return localFdsc3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fdsc3
                               */
                               public void setFdsc3(Char20 param){
                            
                                            this.localFdsc3=param;
                                    

                               }
                            

                        /**
                        * field for Heat4
                        */

                        
                                    protected Char40 localHeat4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char40
                           */
                           public  Char40 getHeat4(){
                               return localHeat4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Heat4
                               */
                               public void setHeat4(Char40 param){
                            
                                            this.localHeat4=param;
                                    

                               }
                            

                        /**
                        * field for Hdsc4
                        */

                        
                                    protected Char20 localHdsc4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHdsc4(){
                               return localHdsc4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hdsc4
                               */
                               public void setHdsc4(Char20 param){
                            
                                            this.localHdsc4=param;
                                    

                               }
                            

                        /**
                        * field for Temp4
                        */

                        
                                    protected Char15 localTemp4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getTemp4(){
                               return localTemp4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Temp4
                               */
                               public void setTemp4(Char15 param){
                            
                                            this.localTemp4=param;
                                    

                               }
                            

                        /**
                        * field for Hold4
                        */

                        
                                    protected Char20 localHold4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHold4(){
                               return localHold4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hold4
                               */
                               public void setHold4(Char20 param){
                            
                                            this.localHold4=param;
                                    

                               }
                            

                        /**
                        * field for Hodsc4
                        */

                        
                                    protected Char20 localHodsc4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHodsc4(){
                               return localHodsc4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hodsc4
                               */
                               public void setHodsc4(Char20 param){
                            
                                            this.localHodsc4=param;
                                    

                               }
                            

                        /**
                        * field for Cool4
                        */

                        
                                    protected Char21 localCool4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char21
                           */
                           public  Char21 getCool4(){
                               return localCool4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cool4
                               */
                               public void setCool4(Char21 param){
                            
                                            this.localCool4=param;
                                    

                               }
                            

                        /**
                        * field for Cdsc4
                        */

                        
                                    protected Char20 localCdsc4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getCdsc4(){
                               return localCdsc4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cdsc4
                               */
                               public void setCdsc4(Char20 param){
                            
                                            this.localCdsc4=param;
                                    

                               }
                            

                        /**
                        * field for FeMax
                        */

                        
                                    protected Quantum183 localFeMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getFeMax(){
                               return localFeMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FeMax
                               */
                               public void setFeMax(Quantum183 param){
                            
                                            this.localFeMax=param;
                                    

                               }
                            

                        /**
                        * field for FeMin
                        */

                        
                                    protected Quantum183 localFeMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getFeMin(){
                               return localFeMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FeMin
                               */
                               public void setFeMin(Quantum183 param){
                            
                                            this.localFeMin=param;
                                    

                               }
                            

                        /**
                        * field for MoMin
                        */

                        
                                    protected Quantum183 localMoMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getMoMin(){
                               return localMoMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MoMin
                               */
                               public void setMoMin(Quantum183 param){
                            
                                            this.localMoMin=param;
                                    

                               }
                            

                        /**
                        * field for MoMax
                        */

                        
                                    protected Quantum183 localMoMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getMoMax(){
                               return localMoMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MoMax
                               */
                               public void setMoMax(Quantum183 param){
                            
                                            this.localMoMax=param;
                                    

                               }
                            

                        /**
                        * field for VMin
                        */

                        
                                    protected Quantum183 localVMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getVMin(){
                               return localVMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VMin
                               */
                               public void setVMin(Quantum183 param){
                            
                                            this.localVMin=param;
                                    

                               }
                            

                        /**
                        * field for VMax
                        */

                        
                                    protected Quantum183 localVMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getVMax(){
                               return localVMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VMax
                               */
                               public void setVMax(Quantum183 param){
                            
                                            this.localVMax=param;
                                    

                               }
                            

                        /**
                        * field for AlMin
                        */

                        
                                    protected Quantum183 localAlMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getAlMin(){
                               return localAlMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AlMin
                               */
                               public void setAlMin(Quantum183 param){
                            
                                            this.localAlMin=param;
                                    

                               }
                            

                        /**
                        * field for AlMax
                        */

                        
                                    protected Quantum183 localAlMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getAlMax(){
                               return localAlMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AlMax
                               */
                               public void setAlMax(Quantum183 param){
                            
                                            this.localAlMax=param;
                                    

                               }
                            

                        /**
                        * field for NbMin
                        */

                        
                                    protected Quantum183 localNbMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getNbMin(){
                               return localNbMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NbMin
                               */
                               public void setNbMin(Quantum183 param){
                            
                                            this.localNbMin=param;
                                    

                               }
                            

                        /**
                        * field for NbMax
                        */

                        
                                    protected Quantum183 localNbMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getNbMax(){
                               return localNbMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NbMax
                               */
                               public void setNbMax(Quantum183 param){
                            
                                            this.localNbMax=param;
                                    

                               }
                            

                        /**
                        * field for WMin
                        */

                        
                                    protected Quantum183 localWMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getWMin(){
                               return localWMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WMin
                               */
                               public void setWMin(Quantum183 param){
                            
                                            this.localWMin=param;
                                    

                               }
                            

                        /**
                        * field for WMax
                        */

                        
                                    protected Quantum183 localWMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getWMax(){
                               return localWMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WMax
                               */
                               public void setWMax(Quantum183 param){
                            
                                            this.localWMax=param;
                                    

                               }
                            

                        /**
                        * field for ZnMin
                        */

                        
                                    protected Quantum183 localZnMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZnMin(){
                               return localZnMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZnMin
                               */
                               public void setZnMin(Quantum183 param){
                            
                                            this.localZnMin=param;
                                    

                               }
                            

                        /**
                        * field for ZnMax
                        */

                        
                                    protected Quantum183 localZnMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZnMax(){
                               return localZnMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZnMax
                               */
                               public void setZnMax(Quantum183 param){
                            
                                            this.localZnMax=param;
                                    

                               }
                            

                        /**
                        * field for TiMin
                        */

                        
                                    protected Quantum183 localTiMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getTiMin(){
                               return localTiMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TiMin
                               */
                               public void setTiMin(Quantum183 param){
                            
                                            this.localTiMin=param;
                                    

                               }
                            

                        /**
                        * field for TiMax
                        */

                        
                                    protected Quantum183 localTiMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getTiMax(){
                               return localTiMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TiMax
                               */
                               public void setTiMax(Quantum183 param){
                            
                                            this.localTiMax=param;
                                    

                               }
                            

                        /**
                        * field for NMin
                        */

                        
                                    protected Quantum184 localNMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum184
                           */
                           public  Quantum184 getNMin(){
                               return localNMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NMin
                               */
                               public void setNMin(Quantum184 param){
                            
                                            this.localNMin=param;
                                    

                               }
                            

                        /**
                        * field for NMax
                        */

                        
                                    protected Quantum184 localNMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum184
                           */
                           public  Quantum184 getNMax(){
                               return localNMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NMax
                               */
                               public void setNMax(Quantum184 param){
                            
                                            this.localNMax=param;
                                    

                               }
                            

                        /**
                        * field for Free1Min
                        */

                        
                                    protected Quantum183 localFree1Min ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getFree1Min(){
                               return localFree1Min;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free1Min
                               */
                               public void setFree1Min(Quantum183 param){
                            
                                            this.localFree1Min=param;
                                    

                               }
                            

                        /**
                        * field for Free1Max
                        */

                        
                                    protected Quantum183 localFree1Max ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getFree1Max(){
                               return localFree1Max;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free1Max
                               */
                               public void setFree1Max(Quantum183 param){
                            
                                            this.localFree1Max=param;
                                    

                               }
                            

                        /**
                        * field for Free2Min
                        */

                        
                                    protected Quantum183 localFree2Min ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getFree2Min(){
                               return localFree2Min;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free2Min
                               */
                               public void setFree2Min(Quantum183 param){
                            
                                            this.localFree2Min=param;
                                    

                               }
                            

                        /**
                        * field for Free2Max
                        */

                        
                                    protected Quantum183 localFree2Max ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getFree2Max(){
                               return localFree2Max;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free2Max
                               */
                               public void setFree2Max(Quantum183 param){
                            
                                            this.localFree2Max=param;
                                    

                               }
                            

                        /**
                        * field for Free3Min
                        */

                        
                                    protected Quantum183 localFree3Min ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getFree3Min(){
                               return localFree3Min;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free3Min
                               */
                               public void setFree3Min(Quantum183 param){
                            
                                            this.localFree3Min=param;
                                    

                               }
                            

                        /**
                        * field for Free3Max
                        */

                        
                                    protected Quantum183 localFree3Max ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getFree3Max(){
                               return localFree3Max;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free3Max
                               */
                               public void setFree3Max(Quantum183 param){
                            
                                            this.localFree3Max=param;
                                    

                               }
                            

                        /**
                        * field for Free1MinDes
                        */

                        
                                    protected Char25 localFree1MinDes ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getFree1MinDes(){
                               return localFree1MinDes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free1MinDes
                               */
                               public void setFree1MinDes(Char25 param){
                            
                                            this.localFree1MinDes=param;
                                    

                               }
                            

                        /**
                        * field for Free1MaxDes
                        */

                        
                                    protected Char25 localFree1MaxDes ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getFree1MaxDes(){
                               return localFree1MaxDes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free1MaxDes
                               */
                               public void setFree1MaxDes(Char25 param){
                            
                                            this.localFree1MaxDes=param;
                                    

                               }
                            

                        /**
                        * field for Free2MinDes
                        */

                        
                                    protected Char25 localFree2MinDes ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getFree2MinDes(){
                               return localFree2MinDes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free2MinDes
                               */
                               public void setFree2MinDes(Char25 param){
                            
                                            this.localFree2MinDes=param;
                                    

                               }
                            

                        /**
                        * field for Free2MaxDes
                        */

                        
                                    protected Char25 localFree2MaxDes ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getFree2MaxDes(){
                               return localFree2MaxDes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free2MaxDes
                               */
                               public void setFree2MaxDes(Char25 param){
                            
                                            this.localFree2MaxDes=param;
                                    

                               }
                            

                        /**
                        * field for Free3MinDes
                        */

                        
                                    protected Char25 localFree3MinDes ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getFree3MinDes(){
                               return localFree3MinDes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free3MinDes
                               */
                               public void setFree3MinDes(Char25 param){
                            
                                            this.localFree3MinDes=param;
                                    

                               }
                            

                        /**
                        * field for Free3MaxDes
                        */

                        
                                    protected Char25 localFree3MaxDes ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getFree3MaxDes(){
                               return localFree3MaxDes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Free3MaxDes
                               */
                               public void setFree3MaxDes(Char25 param){
                            
                                            this.localFree3MaxDes=param;
                                    

                               }
                            

                        /**
                        * field for JTemp
                        */

                        
                                    protected Char8 localJTemp ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJTemp(){
                               return localJTemp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JTemp
                               */
                               public void setJTemp(Char8 param){
                            
                                            this.localJTemp=param;
                                    

                               }
                            

                        /**
                        * field for JAvg
                        */

                        
                                    protected Char8 localJAvg ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJAvg(){
                               return localJAvg;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JAvg
                               */
                               public void setJAvg(Char8 param){
                            
                                            this.localJAvg=param;
                                    

                               }
                            

                        /**
                        * field for JMin
                        */

                        
                                    protected Char8 localJMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJMin(){
                               return localJMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JMin
                               */
                               public void setJMin(Char8 param){
                            
                                            this.localJMin=param;
                                    

                               }
                            

                        /**
                        * field for JTemp2
                        */

                        
                                    protected Char8 localJTemp2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJTemp2(){
                               return localJTemp2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JTemp2
                               */
                               public void setJTemp2(Char8 param){
                            
                                            this.localJTemp2=param;
                                    

                               }
                            

                        /**
                        * field for JAvg2
                        */

                        
                                    protected Char8 localJAvg2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJAvg2(){
                               return localJAvg2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JAvg2
                               */
                               public void setJAvg2(Char8 param){
                            
                                            this.localJAvg2=param;
                                    

                               }
                            

                        /**
                        * field for JMin2
                        */

                        
                                    protected Char8 localJMin2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJMin2(){
                               return localJMin2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JMin2
                               */
                               public void setJMin2(Char8 param){
                            
                                            this.localJMin2=param;
                                    

                               }
                            

                        /**
                        * field for JTemp3
                        */

                        
                                    protected Char8 localJTemp3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJTemp3(){
                               return localJTemp3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JTemp3
                               */
                               public void setJTemp3(Char8 param){
                            
                                            this.localJTemp3=param;
                                    

                               }
                            

                        /**
                        * field for JAvg3
                        */

                        
                                    protected Char8 localJAvg3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJAvg3(){
                               return localJAvg3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JAvg3
                               */
                               public void setJAvg3(Char8 param){
                            
                                            this.localJAvg3=param;
                                    

                               }
                            

                        /**
                        * field for JMin3
                        */

                        
                                    protected Char8 localJMin3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJMin3(){
                               return localJMin3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JMin3
                               */
                               public void setJMin3(Char8 param){
                            
                                            this.localJMin3=param;
                                    

                               }
                            

                        /**
                        * field for JTemp4
                        */

                        
                                    protected Char8 localJTemp4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJTemp4(){
                               return localJTemp4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JTemp4
                               */
                               public void setJTemp4(Char8 param){
                            
                                            this.localJTemp4=param;
                                    

                               }
                            

                        /**
                        * field for JAvg4
                        */

                        
                                    protected Char8 localJAvg4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJAvg4(){
                               return localJAvg4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JAvg4
                               */
                               public void setJAvg4(Char8 param){
                            
                                            this.localJAvg4=param;
                                    

                               }
                            

                        /**
                        * field for JMin4
                        */

                        
                                    protected Char8 localJMin4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJMin4(){
                               return localJMin4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JMin4
                               */
                               public void setJMin4(Char8 param){
                            
                                            this.localJMin4=param;
                                    

                               }
                            

                        /**
                        * field for JTemp5
                        */

                        
                                    protected Char8 localJTemp5 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJTemp5(){
                               return localJTemp5;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JTemp5
                               */
                               public void setJTemp5(Char8 param){
                            
                                            this.localJTemp5=param;
                                    

                               }
                            

                        /**
                        * field for JAvg5
                        */

                        
                                    protected Char8 localJAvg5 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJAvg5(){
                               return localJAvg5;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JAvg5
                               */
                               public void setJAvg5(Char8 param){
                            
                                            this.localJAvg5=param;
                                    

                               }
                            

                        /**
                        * field for JMin5
                        */

                        
                                    protected Char8 localJMin5 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJMin5(){
                               return localJMin5;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JMin5
                               */
                               public void setJMin5(Char8 param){
                            
                                            this.localJMin5=param;
                                    

                               }
                            

                        /**
                        * field for JTemp6
                        */

                        
                                    protected Char8 localJTemp6 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJTemp6(){
                               return localJTemp6;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JTemp6
                               */
                               public void setJTemp6(Char8 param){
                            
                                            this.localJTemp6=param;
                                    

                               }
                            

                        /**
                        * field for JAvg6
                        */

                        
                                    protected Char8 localJAvg6 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJAvg6(){
                               return localJAvg6;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JAvg6
                               */
                               public void setJAvg6(Char8 param){
                            
                                            this.localJAvg6=param;
                                    

                               }
                            

                        /**
                        * field for JMin6
                        */

                        
                                    protected Char8 localJMin6 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char8
                           */
                           public  Char8 getJMin6(){
                               return localJMin6;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param JMin6
                               */
                               public void setJMin6(Char8 param){
                            
                                            this.localJMin6=param;
                                    

                               }
                            

                        /**
                        * field for ZiduanStr
                        */

                        
                                    protected Char20 localZiduanStr ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getZiduanStr(){
                               return localZiduanStr;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZiduanStr
                               */
                               public void setZiduanStr(Char20 param){
                            
                                            this.localZiduanStr=param;
                                    

                               }
                            

                        /**
                        * field for Ys2Min
                        */

                        
                                    protected Quantum183 localYs2Min ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getYs2Min(){
                               return localYs2Min;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ys2Min
                               */
                               public void setYs2Min(Quantum183 param){
                            
                                            this.localYs2Min=param;
                                    

                               }
                            

                        /**
                        * field for Ys2Max
                        */

                        
                                    protected Quantum183 localYs2Max ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getYs2Max(){
                               return localYs2Max;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ys2Max
                               */
                               public void setYs2Max(Quantum183 param){
                            
                                            this.localYs2Max=param;
                                    

                               }
                            

                        /**
                        * field for Pt
                        */

                        
                                    protected Char2 localPt ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char2
                           */
                           public  Char2 getPt(){
                               return localPt;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Pt
                               */
                               public void setPt(Char2 param){
                            
                                            this.localPt=param;
                                    

                               }
                            

                        /**
                        * field for CeMax
                        */

                        
                                    protected Quantum183 localCeMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCeMax(){
                               return localCeMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CeMax
                               */
                               public void setCeMax(Quantum183 param){
                            
                                            this.localCeMax=param;
                                    

                               }
                            

                        /**
                        * field for PrenMin
                        */

                        
                                    protected Quantum183 localPrenMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getPrenMin(){
                               return localPrenMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PrenMin
                               */
                               public void setPrenMin(Quantum183 param){
                            
                                            this.localPrenMin=param;
                                    

                               }
                            

                        /**
                        * field for PrenB
                        */

                        
                                    protected Char1 localPrenB ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getPrenB(){
                               return localPrenB;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PrenB
                               */
                               public void setPrenB(Char1 param){
                            
                                            this.localPrenB=param;
                                    

                               }
                            

                        /**
                        * field for ZfeMin
                        */

                        
                                    protected Quantum183 localZfeMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZfeMin(){
                               return localZfeMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZfeMin
                               */
                               public void setZfeMin(Quantum183 param){
                            
                                            this.localZfeMin=param;
                                    

                               }
                            

                        /**
                        * field for ZfeMax
                        */

                        
                                    protected Quantum183 localZfeMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZfeMax(){
                               return localZfeMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZfeMax
                               */
                               public void setZfeMax(Quantum183 param){
                            
                                            this.localZfeMax=param;
                                    

                               }
                            

                        /**
                        * field for ZcaMin
                        */

                        
                                    protected Quantum183 localZcaMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZcaMin(){
                               return localZcaMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZcaMin
                               */
                               public void setZcaMin(Quantum183 param){
                            
                                            this.localZcaMin=param;
                                    

                               }
                            

                        /**
                        * field for ZcaMax
                        */

                        
                                    protected Quantum183 localZcaMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZcaMax(){
                               return localZcaMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZcaMax
                               */
                               public void setZcaMax(Quantum183 param){
                            
                                            this.localZcaMax=param;
                                    

                               }
                            

                        /**
                        * field for HMin
                        */

                        
                                    protected Quantum183 localHMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getHMin(){
                               return localHMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HMin
                               */
                               public void setHMin(Quantum183 param){
                            
                                            this.localHMin=param;
                                    

                               }
                            

                        /**
                        * field for HMax
                        */

                        
                                    protected Quantum183 localHMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getHMax(){
                               return localHMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HMax
                               */
                               public void setHMax(Quantum183 param){
                            
                                            this.localHMax=param;
                                    

                               }
                            

                        /**
                        * field for OMin
                        */

                        
                                    protected Quantum183 localOMin ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getOMin(){
                               return localOMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OMin
                               */
                               public void setOMin(Quantum183 param){
                            
                                            this.localOMin=param;
                                    

                               }
                            

                        /**
                        * field for OMax
                        */

                        
                                    protected Quantum183 localOMax ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getOMax(){
                               return localOMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OMax
                               */
                               public void setOMax(Quantum183 param){
                            
                                            this.localOMax=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Zzcaizhi.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:soap:functions:mc-style");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":Zzcaizhi",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Zzcaizhi",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localMandt==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Mandt cannot be null!!");
                                            }
                                           localMandt.serialize(new javax.xml.namespace.QName("","Mandt"),
                                               factory,xmlWriter);
                                        
                                            if (localZcz==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Zcz cannot be null!!");
                                            }
                                           localZcz.serialize(new javax.xml.namespace.QName("","Zcz"),
                                               factory,xmlWriter);
                                        
                                            if (localVbeln==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Vbeln cannot be null!!");
                                            }
                                           localVbeln.serialize(new javax.xml.namespace.QName("","Vbeln"),
                                               factory,xmlWriter);
                                        
                                            if (localPosnr==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Posnr cannot be null!!");
                                            }
                                           localPosnr.serialize(new javax.xml.namespace.QName("","Posnr"),
                                               factory,xmlWriter);
                                        
                                            if (localStd==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Std cannot be null!!");
                                            }
                                           localStd.serialize(new javax.xml.namespace.QName("","Std"),
                                               factory,xmlWriter);
                                        
                                            if (localSpecificate==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Specificate cannot be null!!");
                                            }
                                           localSpecificate.serialize(new javax.xml.namespace.QName("","Specificate"),
                                               factory,xmlWriter);
                                        
                                            if (localCe==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Ce cannot be null!!");
                                            }
                                           localCe.serialize(new javax.xml.namespace.QName("","Ce"),
                                               factory,xmlWriter);
                                        
                                            if (localPren==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Pren cannot be null!!");
                                            }
                                           localPren.serialize(new javax.xml.namespace.QName("","Pren"),
                                               factory,xmlWriter);
                                        
                                            if (localZdel==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Zdel cannot be null!!");
                                            }
                                           localZdel.serialize(new javax.xml.namespace.QName("","Zdel"),
                                               factory,xmlWriter);
                                        
                                            if (localCdate==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cdate cannot be null!!");
                                            }
                                           localCdate.serialize(new javax.xml.namespace.QName("","Cdate"),
                                               factory,xmlWriter);
                                        
                                            if (localMdate==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Mdate cannot be null!!");
                                            }
                                           localMdate.serialize(new javax.xml.namespace.QName("","Mdate"),
                                               factory,xmlWriter);
                                        
                                            if (localCuser==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cuser cannot be null!!");
                                            }
                                           localCuser.serialize(new javax.xml.namespace.QName("","Cuser"),
                                               factory,xmlWriter);
                                        
                                            if (localMuser==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Muser cannot be null!!");
                                            }
                                           localMuser.serialize(new javax.xml.namespace.QName("","Muser"),
                                               factory,xmlWriter);
                                        
                                            if (localCMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CMin cannot be null!!");
                                            }
                                           localCMin.serialize(new javax.xml.namespace.QName("","CMin"),
                                               factory,xmlWriter);
                                        
                                            if (localCMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CMax cannot be null!!");
                                            }
                                           localCMax.serialize(new javax.xml.namespace.QName("","CMax"),
                                               factory,xmlWriter);
                                        
                                            if (localSiMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SiMin cannot be null!!");
                                            }
                                           localSiMin.serialize(new javax.xml.namespace.QName("","SiMin"),
                                               factory,xmlWriter);
                                        
                                            if (localSiMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SiMax cannot be null!!");
                                            }
                                           localSiMax.serialize(new javax.xml.namespace.QName("","SiMax"),
                                               factory,xmlWriter);
                                        
                                            if (localMnMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MnMin cannot be null!!");
                                            }
                                           localMnMin.serialize(new javax.xml.namespace.QName("","MnMin"),
                                               factory,xmlWriter);
                                        
                                            if (localMnMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MnMax cannot be null!!");
                                            }
                                           localMnMax.serialize(new javax.xml.namespace.QName("","MnMax"),
                                               factory,xmlWriter);
                                        
                                            if (localPMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PMin cannot be null!!");
                                            }
                                           localPMin.serialize(new javax.xml.namespace.QName("","PMin"),
                                               factory,xmlWriter);
                                        
                                            if (localPMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PMax cannot be null!!");
                                            }
                                           localPMax.serialize(new javax.xml.namespace.QName("","PMax"),
                                               factory,xmlWriter);
                                        
                                            if (localSMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SMin cannot be null!!");
                                            }
                                           localSMin.serialize(new javax.xml.namespace.QName("","SMin"),
                                               factory,xmlWriter);
                                        
                                            if (localSMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SMax cannot be null!!");
                                            }
                                           localSMax.serialize(new javax.xml.namespace.QName("","SMax"),
                                               factory,xmlWriter);
                                        
                                            if (localCrMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CrMin cannot be null!!");
                                            }
                                           localCrMin.serialize(new javax.xml.namespace.QName("","CrMin"),
                                               factory,xmlWriter);
                                        
                                            if (localCrMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CrMax cannot be null!!");
                                            }
                                           localCrMax.serialize(new javax.xml.namespace.QName("","CrMax"),
                                               factory,xmlWriter);
                                        
                                            if (localNiMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NiMin cannot be null!!");
                                            }
                                           localNiMin.serialize(new javax.xml.namespace.QName("","NiMin"),
                                               factory,xmlWriter);
                                        
                                            if (localNiMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NiMax cannot be null!!");
                                            }
                                           localNiMax.serialize(new javax.xml.namespace.QName("","NiMax"),
                                               factory,xmlWriter);
                                        
                                            if (localCuMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CuMin cannot be null!!");
                                            }
                                           localCuMin.serialize(new javax.xml.namespace.QName("","CuMin"),
                                               factory,xmlWriter);
                                        
                                            if (localCuMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CuMax cannot be null!!");
                                            }
                                           localCuMax.serialize(new javax.xml.namespace.QName("","CuMax"),
                                               factory,xmlWriter);
                                        
                                            if (localZrMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZrMin cannot be null!!");
                                            }
                                           localZrMin.serialize(new javax.xml.namespace.QName("","ZrMin"),
                                               factory,xmlWriter);
                                        
                                            if (localZrMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZrMax cannot be null!!");
                                            }
                                           localZrMax.serialize(new javax.xml.namespace.QName("","ZrMax"),
                                               factory,xmlWriter);
                                        
                                            if (localSnMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SnMin cannot be null!!");
                                            }
                                           localSnMin.serialize(new javax.xml.namespace.QName("","SnMin"),
                                               factory,xmlWriter);
                                        
                                            if (localSnMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SnMax cannot be null!!");
                                            }
                                           localSnMax.serialize(new javax.xml.namespace.QName("","SnMax"),
                                               factory,xmlWriter);
                                        
                                            if (localPbMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PbMin cannot be null!!");
                                            }
                                           localPbMin.serialize(new javax.xml.namespace.QName("","PbMin"),
                                               factory,xmlWriter);
                                        
                                            if (localPbMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PbMax cannot be null!!");
                                            }
                                           localPbMax.serialize(new javax.xml.namespace.QName("","PbMax"),
                                               factory,xmlWriter);
                                        
                                            if (localSbMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SbMin cannot be null!!");
                                            }
                                           localSbMin.serialize(new javax.xml.namespace.QName("","SbMin"),
                                               factory,xmlWriter);
                                        
                                            if (localSbMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SbMax cannot be null!!");
                                            }
                                           localSbMax.serialize(new javax.xml.namespace.QName("","SbMax"),
                                               factory,xmlWriter);
                                        
                                            if (localAsMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AsMin cannot be null!!");
                                            }
                                           localAsMin.serialize(new javax.xml.namespace.QName("","AsMin"),
                                               factory,xmlWriter);
                                        
                                            if (localAsMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AsMax cannot be null!!");
                                            }
                                           localAsMax.serialize(new javax.xml.namespace.QName("","AsMax"),
                                               factory,xmlWriter);
                                        
                                            if (localCoMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CoMin cannot be null!!");
                                            }
                                           localCoMin.serialize(new javax.xml.namespace.QName("","CoMin"),
                                               factory,xmlWriter);
                                        
                                            if (localCoMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CoMax cannot be null!!");
                                            }
                                           localCoMax.serialize(new javax.xml.namespace.QName("","CoMax"),
                                               factory,xmlWriter);
                                        
                                            if (localTaMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TaMin cannot be null!!");
                                            }
                                           localTaMin.serialize(new javax.xml.namespace.QName("","TaMin"),
                                               factory,xmlWriter);
                                        
                                            if (localTaMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TaMax cannot be null!!");
                                            }
                                           localTaMax.serialize(new javax.xml.namespace.QName("","TaMax"),
                                               factory,xmlWriter);
                                        
                                            if (localTa1Min==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Ta1Min cannot be null!!");
                                            }
                                           localTa1Min.serialize(new javax.xml.namespace.QName("","Ta1Min"),
                                               factory,xmlWriter);
                                        
                                            if (localTa1Max==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Ta1Max cannot be null!!");
                                            }
                                           localTa1Max.serialize(new javax.xml.namespace.QName("","Ta1Max"),
                                               factory,xmlWriter);
                                        
                                            if (localUser1Min==null){
                                                 throw new org.apache.axis2.databinding.ADBException("User1Min cannot be null!!");
                                            }
                                           localUser1Min.serialize(new javax.xml.namespace.QName("","User1Min"),
                                               factory,xmlWriter);
                                        
                                            if (localUser1Max==null){
                                                 throw new org.apache.axis2.databinding.ADBException("User1Max cannot be null!!");
                                            }
                                           localUser1Max.serialize(new javax.xml.namespace.QName("","User1Max"),
                                               factory,xmlWriter);
                                        
                                            if (localUser2Min==null){
                                                 throw new org.apache.axis2.databinding.ADBException("User2Min cannot be null!!");
                                            }
                                           localUser2Min.serialize(new javax.xml.namespace.QName("","User2Min"),
                                               factory,xmlWriter);
                                        
                                            if (localUser2Max==null){
                                                 throw new org.apache.axis2.databinding.ADBException("User2Max cannot be null!!");
                                            }
                                           localUser2Max.serialize(new javax.xml.namespace.QName("","User2Max"),
                                               factory,xmlWriter);
                                        
                                            if (localUser3Min==null){
                                                 throw new org.apache.axis2.databinding.ADBException("User3Min cannot be null!!");
                                            }
                                           localUser3Min.serialize(new javax.xml.namespace.QName("","User3Min"),
                                               factory,xmlWriter);
                                        
                                            if (localUser3Max==null){
                                                 throw new org.apache.axis2.databinding.ADBException("User3Max cannot be null!!");
                                            }
                                           localUser3Max.serialize(new javax.xml.namespace.QName("","User3Max"),
                                               factory,xmlWriter);
                                        
                                            if (localTsMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TsMin cannot be null!!");
                                            }
                                           localTsMin.serialize(new javax.xml.namespace.QName("","TsMin"),
                                               factory,xmlWriter);
                                        
                                            if (localTsMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TsMax cannot be null!!");
                                            }
                                           localTsMax.serialize(new javax.xml.namespace.QName("","TsMax"),
                                               factory,xmlWriter);
                                        
                                            if (localYsMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("YsMin cannot be null!!");
                                            }
                                           localYsMin.serialize(new javax.xml.namespace.QName("","YsMin"),
                                               factory,xmlWriter);
                                        
                                            if (localYsMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("YsMax cannot be null!!");
                                            }
                                           localYsMax.serialize(new javax.xml.namespace.QName("","YsMax"),
                                               factory,xmlWriter);
                                        
                                            if (localEMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("EMin cannot be null!!");
                                            }
                                           localEMin.serialize(new javax.xml.namespace.QName("","EMin"),
                                               factory,xmlWriter);
                                        
                                            if (localEMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("EMax cannot be null!!");
                                            }
                                           localEMax.serialize(new javax.xml.namespace.QName("","EMax"),
                                               factory,xmlWriter);
                                        
                                            if (localRMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("RMin cannot be null!!");
                                            }
                                           localRMin.serialize(new javax.xml.namespace.QName("","RMin"),
                                               factory,xmlWriter);
                                        
                                            if (localRMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("RMax cannot be null!!");
                                            }
                                           localRMax.serialize(new javax.xml.namespace.QName("","RMax"),
                                               factory,xmlWriter);
                                        
                                            if (localHbMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HbMin cannot be null!!");
                                            }
                                           localHbMin.serialize(new javax.xml.namespace.QName("","HbMin"),
                                               factory,xmlWriter);
                                        
                                            if (localHbMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HbMax cannot be null!!");
                                            }
                                           localHbMax.serialize(new javax.xml.namespace.QName("","HbMax"),
                                               factory,xmlWriter);
                                        
                                            if (localBMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BMax cannot be null!!");
                                            }
                                           localBMax.serialize(new javax.xml.namespace.QName("","BMax"),
                                               factory,xmlWriter);
                                        
                                            if (localBMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BMin cannot be null!!");
                                            }
                                           localBMin.serialize(new javax.xml.namespace.QName("","BMin"),
                                               factory,xmlWriter);
                                        
                                            if (localHeat1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Heat1 cannot be null!!");
                                            }
                                           localHeat1.serialize(new javax.xml.namespace.QName("","Heat1"),
                                               factory,xmlWriter);
                                        
                                            if (localHdsc1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hdsc1 cannot be null!!");
                                            }
                                           localHdsc1.serialize(new javax.xml.namespace.QName("","Hdsc1"),
                                               factory,xmlWriter);
                                        
                                            if (localTemp1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Temp1 cannot be null!!");
                                            }
                                           localTemp1.serialize(new javax.xml.namespace.QName("","Temp1"),
                                               factory,xmlWriter);
                                        
                                            if (localTdsc1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Tdsc1 cannot be null!!");
                                            }
                                           localTdsc1.serialize(new javax.xml.namespace.QName("","Tdsc1"),
                                               factory,xmlWriter);
                                        
                                            if (localHold1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hold1 cannot be null!!");
                                            }
                                           localHold1.serialize(new javax.xml.namespace.QName("","Hold1"),
                                               factory,xmlWriter);
                                        
                                            if (localHodsc1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hodsc1 cannot be null!!");
                                            }
                                           localHodsc1.serialize(new javax.xml.namespace.QName("","Hodsc1"),
                                               factory,xmlWriter);
                                        
                                            if (localCool1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cool1 cannot be null!!");
                                            }
                                           localCool1.serialize(new javax.xml.namespace.QName("","Cool1"),
                                               factory,xmlWriter);
                                        
                                            if (localCdsc1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cdsc1 cannot be null!!");
                                            }
                                           localCdsc1.serialize(new javax.xml.namespace.QName("","Cdsc1"),
                                               factory,xmlWriter);
                                        
                                            if (localFurn1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Furn1 cannot be null!!");
                                            }
                                           localFurn1.serialize(new javax.xml.namespace.QName("","Furn1"),
                                               factory,xmlWriter);
                                        
                                            if (localFdsc1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Fdsc1 cannot be null!!");
                                            }
                                           localFdsc1.serialize(new javax.xml.namespace.QName("","Fdsc1"),
                                               factory,xmlWriter);
                                        
                                            if (localHeat2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Heat2 cannot be null!!");
                                            }
                                           localHeat2.serialize(new javax.xml.namespace.QName("","Heat2"),
                                               factory,xmlWriter);
                                        
                                            if (localHdsc2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hdsc2 cannot be null!!");
                                            }
                                           localHdsc2.serialize(new javax.xml.namespace.QName("","Hdsc2"),
                                               factory,xmlWriter);
                                        
                                            if (localTemp2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Temp2 cannot be null!!");
                                            }
                                           localTemp2.serialize(new javax.xml.namespace.QName("","Temp2"),
                                               factory,xmlWriter);
                                        
                                            if (localTdsc2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Tdsc2 cannot be null!!");
                                            }
                                           localTdsc2.serialize(new javax.xml.namespace.QName("","Tdsc2"),
                                               factory,xmlWriter);
                                        
                                            if (localHold2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hold2 cannot be null!!");
                                            }
                                           localHold2.serialize(new javax.xml.namespace.QName("","Hold2"),
                                               factory,xmlWriter);
                                        
                                            if (localHodsc2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hodsc2 cannot be null!!");
                                            }
                                           localHodsc2.serialize(new javax.xml.namespace.QName("","Hodsc2"),
                                               factory,xmlWriter);
                                        
                                            if (localCool2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cool2 cannot be null!!");
                                            }
                                           localCool2.serialize(new javax.xml.namespace.QName("","Cool2"),
                                               factory,xmlWriter);
                                        
                                            if (localCdsc2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cdsc2 cannot be null!!");
                                            }
                                           localCdsc2.serialize(new javax.xml.namespace.QName("","Cdsc2"),
                                               factory,xmlWriter);
                                        
                                            if (localFurn2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Furn2 cannot be null!!");
                                            }
                                           localFurn2.serialize(new javax.xml.namespace.QName("","Furn2"),
                                               factory,xmlWriter);
                                        
                                            if (localFdsc2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Fdsc2 cannot be null!!");
                                            }
                                           localFdsc2.serialize(new javax.xml.namespace.QName("","Fdsc2"),
                                               factory,xmlWriter);
                                        
                                            if (localHeat3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Heat3 cannot be null!!");
                                            }
                                           localHeat3.serialize(new javax.xml.namespace.QName("","Heat3"),
                                               factory,xmlWriter);
                                        
                                            if (localHdsc3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hdsc3 cannot be null!!");
                                            }
                                           localHdsc3.serialize(new javax.xml.namespace.QName("","Hdsc3"),
                                               factory,xmlWriter);
                                        
                                            if (localTemp3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Temp3 cannot be null!!");
                                            }
                                           localTemp3.serialize(new javax.xml.namespace.QName("","Temp3"),
                                               factory,xmlWriter);
                                        
                                            if (localTdsc3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Tdsc3 cannot be null!!");
                                            }
                                           localTdsc3.serialize(new javax.xml.namespace.QName("","Tdsc3"),
                                               factory,xmlWriter);
                                        
                                            if (localHold3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hold3 cannot be null!!");
                                            }
                                           localHold3.serialize(new javax.xml.namespace.QName("","Hold3"),
                                               factory,xmlWriter);
                                        
                                            if (localHodsc3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hodsc3 cannot be null!!");
                                            }
                                           localHodsc3.serialize(new javax.xml.namespace.QName("","Hodsc3"),
                                               factory,xmlWriter);
                                        
                                            if (localCool3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cool3 cannot be null!!");
                                            }
                                           localCool3.serialize(new javax.xml.namespace.QName("","Cool3"),
                                               factory,xmlWriter);
                                        
                                            if (localCdsc3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cdsc3 cannot be null!!");
                                            }
                                           localCdsc3.serialize(new javax.xml.namespace.QName("","Cdsc3"),
                                               factory,xmlWriter);
                                        
                                            if (localFurn3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Furn3 cannot be null!!");
                                            }
                                           localFurn3.serialize(new javax.xml.namespace.QName("","Furn3"),
                                               factory,xmlWriter);
                                        
                                            if (localFdsc3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Fdsc3 cannot be null!!");
                                            }
                                           localFdsc3.serialize(new javax.xml.namespace.QName("","Fdsc3"),
                                               factory,xmlWriter);
                                        
                                            if (localHeat4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Heat4 cannot be null!!");
                                            }
                                           localHeat4.serialize(new javax.xml.namespace.QName("","Heat4"),
                                               factory,xmlWriter);
                                        
                                            if (localHdsc4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hdsc4 cannot be null!!");
                                            }
                                           localHdsc4.serialize(new javax.xml.namespace.QName("","Hdsc4"),
                                               factory,xmlWriter);
                                        
                                            if (localTemp4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Temp4 cannot be null!!");
                                            }
                                           localTemp4.serialize(new javax.xml.namespace.QName("","Temp4"),
                                               factory,xmlWriter);
                                        
                                            if (localHold4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hold4 cannot be null!!");
                                            }
                                           localHold4.serialize(new javax.xml.namespace.QName("","Hold4"),
                                               factory,xmlWriter);
                                        
                                            if (localHodsc4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Hodsc4 cannot be null!!");
                                            }
                                           localHodsc4.serialize(new javax.xml.namespace.QName("","Hodsc4"),
                                               factory,xmlWriter);
                                        
                                            if (localCool4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cool4 cannot be null!!");
                                            }
                                           localCool4.serialize(new javax.xml.namespace.QName("","Cool4"),
                                               factory,xmlWriter);
                                        
                                            if (localCdsc4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Cdsc4 cannot be null!!");
                                            }
                                           localCdsc4.serialize(new javax.xml.namespace.QName("","Cdsc4"),
                                               factory,xmlWriter);
                                        
                                            if (localFeMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FeMax cannot be null!!");
                                            }
                                           localFeMax.serialize(new javax.xml.namespace.QName("","FeMax"),
                                               factory,xmlWriter);
                                        
                                            if (localFeMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FeMin cannot be null!!");
                                            }
                                           localFeMin.serialize(new javax.xml.namespace.QName("","FeMin"),
                                               factory,xmlWriter);
                                        
                                            if (localMoMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MoMin cannot be null!!");
                                            }
                                           localMoMin.serialize(new javax.xml.namespace.QName("","MoMin"),
                                               factory,xmlWriter);
                                        
                                            if (localMoMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MoMax cannot be null!!");
                                            }
                                           localMoMax.serialize(new javax.xml.namespace.QName("","MoMax"),
                                               factory,xmlWriter);
                                        
                                            if (localVMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("VMin cannot be null!!");
                                            }
                                           localVMin.serialize(new javax.xml.namespace.QName("","VMin"),
                                               factory,xmlWriter);
                                        
                                            if (localVMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("VMax cannot be null!!");
                                            }
                                           localVMax.serialize(new javax.xml.namespace.QName("","VMax"),
                                               factory,xmlWriter);
                                        
                                            if (localAlMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AlMin cannot be null!!");
                                            }
                                           localAlMin.serialize(new javax.xml.namespace.QName("","AlMin"),
                                               factory,xmlWriter);
                                        
                                            if (localAlMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AlMax cannot be null!!");
                                            }
                                           localAlMax.serialize(new javax.xml.namespace.QName("","AlMax"),
                                               factory,xmlWriter);
                                        
                                            if (localNbMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NbMin cannot be null!!");
                                            }
                                           localNbMin.serialize(new javax.xml.namespace.QName("","NbMin"),
                                               factory,xmlWriter);
                                        
                                            if (localNbMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NbMax cannot be null!!");
                                            }
                                           localNbMax.serialize(new javax.xml.namespace.QName("","NbMax"),
                                               factory,xmlWriter);
                                        
                                            if (localWMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("WMin cannot be null!!");
                                            }
                                           localWMin.serialize(new javax.xml.namespace.QName("","WMin"),
                                               factory,xmlWriter);
                                        
                                            if (localWMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("WMax cannot be null!!");
                                            }
                                           localWMax.serialize(new javax.xml.namespace.QName("","WMax"),
                                               factory,xmlWriter);
                                        
                                            if (localZnMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZnMin cannot be null!!");
                                            }
                                           localZnMin.serialize(new javax.xml.namespace.QName("","ZnMin"),
                                               factory,xmlWriter);
                                        
                                            if (localZnMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZnMax cannot be null!!");
                                            }
                                           localZnMax.serialize(new javax.xml.namespace.QName("","ZnMax"),
                                               factory,xmlWriter);
                                        
                                            if (localTiMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TiMin cannot be null!!");
                                            }
                                           localTiMin.serialize(new javax.xml.namespace.QName("","TiMin"),
                                               factory,xmlWriter);
                                        
                                            if (localTiMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TiMax cannot be null!!");
                                            }
                                           localTiMax.serialize(new javax.xml.namespace.QName("","TiMax"),
                                               factory,xmlWriter);
                                        
                                            if (localNMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NMin cannot be null!!");
                                            }
                                           localNMin.serialize(new javax.xml.namespace.QName("","NMin"),
                                               factory,xmlWriter);
                                        
                                            if (localNMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NMax cannot be null!!");
                                            }
                                           localNMax.serialize(new javax.xml.namespace.QName("","NMax"),
                                               factory,xmlWriter);
                                        
                                            if (localFree1Min==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free1Min cannot be null!!");
                                            }
                                           localFree1Min.serialize(new javax.xml.namespace.QName("","Free1Min"),
                                               factory,xmlWriter);
                                        
                                            if (localFree1Max==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free1Max cannot be null!!");
                                            }
                                           localFree1Max.serialize(new javax.xml.namespace.QName("","Free1Max"),
                                               factory,xmlWriter);
                                        
                                            if (localFree2Min==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free2Min cannot be null!!");
                                            }
                                           localFree2Min.serialize(new javax.xml.namespace.QName("","Free2Min"),
                                               factory,xmlWriter);
                                        
                                            if (localFree2Max==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free2Max cannot be null!!");
                                            }
                                           localFree2Max.serialize(new javax.xml.namespace.QName("","Free2Max"),
                                               factory,xmlWriter);
                                        
                                            if (localFree3Min==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free3Min cannot be null!!");
                                            }
                                           localFree3Min.serialize(new javax.xml.namespace.QName("","Free3Min"),
                                               factory,xmlWriter);
                                        
                                            if (localFree3Max==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free3Max cannot be null!!");
                                            }
                                           localFree3Max.serialize(new javax.xml.namespace.QName("","Free3Max"),
                                               factory,xmlWriter);
                                        
                                            if (localFree1MinDes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free1MinDes cannot be null!!");
                                            }
                                           localFree1MinDes.serialize(new javax.xml.namespace.QName("","Free1MinDes"),
                                               factory,xmlWriter);
                                        
                                            if (localFree1MaxDes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free1MaxDes cannot be null!!");
                                            }
                                           localFree1MaxDes.serialize(new javax.xml.namespace.QName("","Free1MaxDes"),
                                               factory,xmlWriter);
                                        
                                            if (localFree2MinDes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free2MinDes cannot be null!!");
                                            }
                                           localFree2MinDes.serialize(new javax.xml.namespace.QName("","Free2MinDes"),
                                               factory,xmlWriter);
                                        
                                            if (localFree2MaxDes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free2MaxDes cannot be null!!");
                                            }
                                           localFree2MaxDes.serialize(new javax.xml.namespace.QName("","Free2MaxDes"),
                                               factory,xmlWriter);
                                        
                                            if (localFree3MinDes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free3MinDes cannot be null!!");
                                            }
                                           localFree3MinDes.serialize(new javax.xml.namespace.QName("","Free3MinDes"),
                                               factory,xmlWriter);
                                        
                                            if (localFree3MaxDes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Free3MaxDes cannot be null!!");
                                            }
                                           localFree3MaxDes.serialize(new javax.xml.namespace.QName("","Free3MaxDes"),
                                               factory,xmlWriter);
                                        
                                            if (localJTemp==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JTemp cannot be null!!");
                                            }
                                           localJTemp.serialize(new javax.xml.namespace.QName("","JTemp"),
                                               factory,xmlWriter);
                                        
                                            if (localJAvg==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JAvg cannot be null!!");
                                            }
                                           localJAvg.serialize(new javax.xml.namespace.QName("","JAvg"),
                                               factory,xmlWriter);
                                        
                                            if (localJMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JMin cannot be null!!");
                                            }
                                           localJMin.serialize(new javax.xml.namespace.QName("","JMin"),
                                               factory,xmlWriter);
                                        
                                            if (localJTemp2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JTemp2 cannot be null!!");
                                            }
                                           localJTemp2.serialize(new javax.xml.namespace.QName("","JTemp2"),
                                               factory,xmlWriter);
                                        
                                            if (localJAvg2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JAvg2 cannot be null!!");
                                            }
                                           localJAvg2.serialize(new javax.xml.namespace.QName("","JAvg2"),
                                               factory,xmlWriter);
                                        
                                            if (localJMin2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JMin2 cannot be null!!");
                                            }
                                           localJMin2.serialize(new javax.xml.namespace.QName("","JMin2"),
                                               factory,xmlWriter);
                                        
                                            if (localJTemp3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JTemp3 cannot be null!!");
                                            }
                                           localJTemp3.serialize(new javax.xml.namespace.QName("","JTemp3"),
                                               factory,xmlWriter);
                                        
                                            if (localJAvg3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JAvg3 cannot be null!!");
                                            }
                                           localJAvg3.serialize(new javax.xml.namespace.QName("","JAvg3"),
                                               factory,xmlWriter);
                                        
                                            if (localJMin3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JMin3 cannot be null!!");
                                            }
                                           localJMin3.serialize(new javax.xml.namespace.QName("","JMin3"),
                                               factory,xmlWriter);
                                        
                                            if (localJTemp4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JTemp4 cannot be null!!");
                                            }
                                           localJTemp4.serialize(new javax.xml.namespace.QName("","JTemp4"),
                                               factory,xmlWriter);
                                        
                                            if (localJAvg4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JAvg4 cannot be null!!");
                                            }
                                           localJAvg4.serialize(new javax.xml.namespace.QName("","JAvg4"),
                                               factory,xmlWriter);
                                        
                                            if (localJMin4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JMin4 cannot be null!!");
                                            }
                                           localJMin4.serialize(new javax.xml.namespace.QName("","JMin4"),
                                               factory,xmlWriter);
                                        
                                            if (localJTemp5==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JTemp5 cannot be null!!");
                                            }
                                           localJTemp5.serialize(new javax.xml.namespace.QName("","JTemp5"),
                                               factory,xmlWriter);
                                        
                                            if (localJAvg5==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JAvg5 cannot be null!!");
                                            }
                                           localJAvg5.serialize(new javax.xml.namespace.QName("","JAvg5"),
                                               factory,xmlWriter);
                                        
                                            if (localJMin5==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JMin5 cannot be null!!");
                                            }
                                           localJMin5.serialize(new javax.xml.namespace.QName("","JMin5"),
                                               factory,xmlWriter);
                                        
                                            if (localJTemp6==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JTemp6 cannot be null!!");
                                            }
                                           localJTemp6.serialize(new javax.xml.namespace.QName("","JTemp6"),
                                               factory,xmlWriter);
                                        
                                            if (localJAvg6==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JAvg6 cannot be null!!");
                                            }
                                           localJAvg6.serialize(new javax.xml.namespace.QName("","JAvg6"),
                                               factory,xmlWriter);
                                        
                                            if (localJMin6==null){
                                                 throw new org.apache.axis2.databinding.ADBException("JMin6 cannot be null!!");
                                            }
                                           localJMin6.serialize(new javax.xml.namespace.QName("","JMin6"),
                                               factory,xmlWriter);
                                        
                                            if (localZiduanStr==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZiduanStr cannot be null!!");
                                            }
                                           localZiduanStr.serialize(new javax.xml.namespace.QName("","ZiduanStr"),
                                               factory,xmlWriter);
                                        
                                            if (localYs2Min==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Ys2Min cannot be null!!");
                                            }
                                           localYs2Min.serialize(new javax.xml.namespace.QName("","Ys2Min"),
                                               factory,xmlWriter);
                                        
                                            if (localYs2Max==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Ys2Max cannot be null!!");
                                            }
                                           localYs2Max.serialize(new javax.xml.namespace.QName("","Ys2Max"),
                                               factory,xmlWriter);
                                        
                                            if (localPt==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Pt cannot be null!!");
                                            }
                                           localPt.serialize(new javax.xml.namespace.QName("","Pt"),
                                               factory,xmlWriter);
                                        
                                            if (localCeMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CeMax cannot be null!!");
                                            }
                                           localCeMax.serialize(new javax.xml.namespace.QName("","CeMax"),
                                               factory,xmlWriter);
                                        
                                            if (localPrenMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PrenMin cannot be null!!");
                                            }
                                           localPrenMin.serialize(new javax.xml.namespace.QName("","PrenMin"),
                                               factory,xmlWriter);
                                        
                                            if (localPrenB==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PrenB cannot be null!!");
                                            }
                                           localPrenB.serialize(new javax.xml.namespace.QName("","PrenB"),
                                               factory,xmlWriter);
                                        
                                            if (localZfeMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZfeMin cannot be null!!");
                                            }
                                           localZfeMin.serialize(new javax.xml.namespace.QName("","ZfeMin"),
                                               factory,xmlWriter);
                                        
                                            if (localZfeMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZfeMax cannot be null!!");
                                            }
                                           localZfeMax.serialize(new javax.xml.namespace.QName("","ZfeMax"),
                                               factory,xmlWriter);
                                        
                                            if (localZcaMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZcaMin cannot be null!!");
                                            }
                                           localZcaMin.serialize(new javax.xml.namespace.QName("","ZcaMin"),
                                               factory,xmlWriter);
                                        
                                            if (localZcaMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZcaMax cannot be null!!");
                                            }
                                           localZcaMax.serialize(new javax.xml.namespace.QName("","ZcaMax"),
                                               factory,xmlWriter);
                                        
                                            if (localHMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HMin cannot be null!!");
                                            }
                                           localHMin.serialize(new javax.xml.namespace.QName("","HMin"),
                                               factory,xmlWriter);
                                        
                                            if (localHMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HMax cannot be null!!");
                                            }
                                           localHMax.serialize(new javax.xml.namespace.QName("","HMax"),
                                               factory,xmlWriter);
                                        
                                            if (localOMin==null){
                                                 throw new org.apache.axis2.databinding.ADBException("OMin cannot be null!!");
                                            }
                                           localOMin.serialize(new javax.xml.namespace.QName("","OMin"),
                                               factory,xmlWriter);
                                        
                                            if (localOMax==null){
                                                 throw new org.apache.axis2.databinding.ADBException("OMax cannot be null!!");
                                            }
                                           localOMax.serialize(new javax.xml.namespace.QName("","OMax"),
                                               factory,xmlWriter);
                                        
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Mandt"));
                            
                            
                                    if (localMandt==null){
                                         throw new org.apache.axis2.databinding.ADBException("Mandt cannot be null!!");
                                    }
                                    elementList.add(localMandt);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Zcz"));
                            
                            
                                    if (localZcz==null){
                                         throw new org.apache.axis2.databinding.ADBException("Zcz cannot be null!!");
                                    }
                                    elementList.add(localZcz);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Vbeln"));
                            
                            
                                    if (localVbeln==null){
                                         throw new org.apache.axis2.databinding.ADBException("Vbeln cannot be null!!");
                                    }
                                    elementList.add(localVbeln);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Posnr"));
                            
                            
                                    if (localPosnr==null){
                                         throw new org.apache.axis2.databinding.ADBException("Posnr cannot be null!!");
                                    }
                                    elementList.add(localPosnr);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Std"));
                            
                            
                                    if (localStd==null){
                                         throw new org.apache.axis2.databinding.ADBException("Std cannot be null!!");
                                    }
                                    elementList.add(localStd);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Specificate"));
                            
                            
                                    if (localSpecificate==null){
                                         throw new org.apache.axis2.databinding.ADBException("Specificate cannot be null!!");
                                    }
                                    elementList.add(localSpecificate);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Ce"));
                            
                            
                                    if (localCe==null){
                                         throw new org.apache.axis2.databinding.ADBException("Ce cannot be null!!");
                                    }
                                    elementList.add(localCe);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Pren"));
                            
                            
                                    if (localPren==null){
                                         throw new org.apache.axis2.databinding.ADBException("Pren cannot be null!!");
                                    }
                                    elementList.add(localPren);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Zdel"));
                            
                            
                                    if (localZdel==null){
                                         throw new org.apache.axis2.databinding.ADBException("Zdel cannot be null!!");
                                    }
                                    elementList.add(localZdel);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cdate"));
                            
                            
                                    if (localCdate==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cdate cannot be null!!");
                                    }
                                    elementList.add(localCdate);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Mdate"));
                            
                            
                                    if (localMdate==null){
                                         throw new org.apache.axis2.databinding.ADBException("Mdate cannot be null!!");
                                    }
                                    elementList.add(localMdate);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cuser"));
                            
                            
                                    if (localCuser==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cuser cannot be null!!");
                                    }
                                    elementList.add(localCuser);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Muser"));
                            
                            
                                    if (localMuser==null){
                                         throw new org.apache.axis2.databinding.ADBException("Muser cannot be null!!");
                                    }
                                    elementList.add(localMuser);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CMin"));
                            
                            
                                    if (localCMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("CMin cannot be null!!");
                                    }
                                    elementList.add(localCMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CMax"));
                            
                            
                                    if (localCMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("CMax cannot be null!!");
                                    }
                                    elementList.add(localCMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SiMin"));
                            
                            
                                    if (localSiMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("SiMin cannot be null!!");
                                    }
                                    elementList.add(localSiMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SiMax"));
                            
                            
                                    if (localSiMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("SiMax cannot be null!!");
                                    }
                                    elementList.add(localSiMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MnMin"));
                            
                            
                                    if (localMnMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("MnMin cannot be null!!");
                                    }
                                    elementList.add(localMnMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MnMax"));
                            
                            
                                    if (localMnMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("MnMax cannot be null!!");
                                    }
                                    elementList.add(localMnMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PMin"));
                            
                            
                                    if (localPMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("PMin cannot be null!!");
                                    }
                                    elementList.add(localPMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PMax"));
                            
                            
                                    if (localPMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("PMax cannot be null!!");
                                    }
                                    elementList.add(localPMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SMin"));
                            
                            
                                    if (localSMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("SMin cannot be null!!");
                                    }
                                    elementList.add(localSMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SMax"));
                            
                            
                                    if (localSMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("SMax cannot be null!!");
                                    }
                                    elementList.add(localSMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CrMin"));
                            
                            
                                    if (localCrMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("CrMin cannot be null!!");
                                    }
                                    elementList.add(localCrMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CrMax"));
                            
                            
                                    if (localCrMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("CrMax cannot be null!!");
                                    }
                                    elementList.add(localCrMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "NiMin"));
                            
                            
                                    if (localNiMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("NiMin cannot be null!!");
                                    }
                                    elementList.add(localNiMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "NiMax"));
                            
                            
                                    if (localNiMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("NiMax cannot be null!!");
                                    }
                                    elementList.add(localNiMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CuMin"));
                            
                            
                                    if (localCuMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("CuMin cannot be null!!");
                                    }
                                    elementList.add(localCuMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CuMax"));
                            
                            
                                    if (localCuMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("CuMax cannot be null!!");
                                    }
                                    elementList.add(localCuMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZrMin"));
                            
                            
                                    if (localZrMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZrMin cannot be null!!");
                                    }
                                    elementList.add(localZrMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZrMax"));
                            
                            
                                    if (localZrMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZrMax cannot be null!!");
                                    }
                                    elementList.add(localZrMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SnMin"));
                            
                            
                                    if (localSnMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("SnMin cannot be null!!");
                                    }
                                    elementList.add(localSnMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SnMax"));
                            
                            
                                    if (localSnMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("SnMax cannot be null!!");
                                    }
                                    elementList.add(localSnMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PbMin"));
                            
                            
                                    if (localPbMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("PbMin cannot be null!!");
                                    }
                                    elementList.add(localPbMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PbMax"));
                            
                            
                                    if (localPbMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("PbMax cannot be null!!");
                                    }
                                    elementList.add(localPbMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SbMin"));
                            
                            
                                    if (localSbMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("SbMin cannot be null!!");
                                    }
                                    elementList.add(localSbMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SbMax"));
                            
                            
                                    if (localSbMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("SbMax cannot be null!!");
                                    }
                                    elementList.add(localSbMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "AsMin"));
                            
                            
                                    if (localAsMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("AsMin cannot be null!!");
                                    }
                                    elementList.add(localAsMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "AsMax"));
                            
                            
                                    if (localAsMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("AsMax cannot be null!!");
                                    }
                                    elementList.add(localAsMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CoMin"));
                            
                            
                                    if (localCoMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("CoMin cannot be null!!");
                                    }
                                    elementList.add(localCoMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CoMax"));
                            
                            
                                    if (localCoMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("CoMax cannot be null!!");
                                    }
                                    elementList.add(localCoMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TaMin"));
                            
                            
                                    if (localTaMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("TaMin cannot be null!!");
                                    }
                                    elementList.add(localTaMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TaMax"));
                            
                            
                                    if (localTaMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("TaMax cannot be null!!");
                                    }
                                    elementList.add(localTaMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Ta1Min"));
                            
                            
                                    if (localTa1Min==null){
                                         throw new org.apache.axis2.databinding.ADBException("Ta1Min cannot be null!!");
                                    }
                                    elementList.add(localTa1Min);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Ta1Max"));
                            
                            
                                    if (localTa1Max==null){
                                         throw new org.apache.axis2.databinding.ADBException("Ta1Max cannot be null!!");
                                    }
                                    elementList.add(localTa1Max);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "User1Min"));
                            
                            
                                    if (localUser1Min==null){
                                         throw new org.apache.axis2.databinding.ADBException("User1Min cannot be null!!");
                                    }
                                    elementList.add(localUser1Min);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "User1Max"));
                            
                            
                                    if (localUser1Max==null){
                                         throw new org.apache.axis2.databinding.ADBException("User1Max cannot be null!!");
                                    }
                                    elementList.add(localUser1Max);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "User2Min"));
                            
                            
                                    if (localUser2Min==null){
                                         throw new org.apache.axis2.databinding.ADBException("User2Min cannot be null!!");
                                    }
                                    elementList.add(localUser2Min);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "User2Max"));
                            
                            
                                    if (localUser2Max==null){
                                         throw new org.apache.axis2.databinding.ADBException("User2Max cannot be null!!");
                                    }
                                    elementList.add(localUser2Max);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "User3Min"));
                            
                            
                                    if (localUser3Min==null){
                                         throw new org.apache.axis2.databinding.ADBException("User3Min cannot be null!!");
                                    }
                                    elementList.add(localUser3Min);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "User3Max"));
                            
                            
                                    if (localUser3Max==null){
                                         throw new org.apache.axis2.databinding.ADBException("User3Max cannot be null!!");
                                    }
                                    elementList.add(localUser3Max);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TsMin"));
                            
                            
                                    if (localTsMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("TsMin cannot be null!!");
                                    }
                                    elementList.add(localTsMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TsMax"));
                            
                            
                                    if (localTsMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("TsMax cannot be null!!");
                                    }
                                    elementList.add(localTsMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "YsMin"));
                            
                            
                                    if (localYsMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("YsMin cannot be null!!");
                                    }
                                    elementList.add(localYsMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "YsMax"));
                            
                            
                                    if (localYsMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("YsMax cannot be null!!");
                                    }
                                    elementList.add(localYsMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "EMin"));
                            
                            
                                    if (localEMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("EMin cannot be null!!");
                                    }
                                    elementList.add(localEMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "EMax"));
                            
                            
                                    if (localEMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("EMax cannot be null!!");
                                    }
                                    elementList.add(localEMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "RMin"));
                            
                            
                                    if (localRMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("RMin cannot be null!!");
                                    }
                                    elementList.add(localRMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "RMax"));
                            
                            
                                    if (localRMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("RMax cannot be null!!");
                                    }
                                    elementList.add(localRMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "HbMin"));
                            
                            
                                    if (localHbMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("HbMin cannot be null!!");
                                    }
                                    elementList.add(localHbMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "HbMax"));
                            
                            
                                    if (localHbMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("HbMax cannot be null!!");
                                    }
                                    elementList.add(localHbMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BMax"));
                            
                            
                                    if (localBMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("BMax cannot be null!!");
                                    }
                                    elementList.add(localBMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BMin"));
                            
                            
                                    if (localBMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("BMin cannot be null!!");
                                    }
                                    elementList.add(localBMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Heat1"));
                            
                            
                                    if (localHeat1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Heat1 cannot be null!!");
                                    }
                                    elementList.add(localHeat1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hdsc1"));
                            
                            
                                    if (localHdsc1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hdsc1 cannot be null!!");
                                    }
                                    elementList.add(localHdsc1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Temp1"));
                            
                            
                                    if (localTemp1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Temp1 cannot be null!!");
                                    }
                                    elementList.add(localTemp1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Tdsc1"));
                            
                            
                                    if (localTdsc1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Tdsc1 cannot be null!!");
                                    }
                                    elementList.add(localTdsc1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hold1"));
                            
                            
                                    if (localHold1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hold1 cannot be null!!");
                                    }
                                    elementList.add(localHold1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hodsc1"));
                            
                            
                                    if (localHodsc1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hodsc1 cannot be null!!");
                                    }
                                    elementList.add(localHodsc1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cool1"));
                            
                            
                                    if (localCool1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cool1 cannot be null!!");
                                    }
                                    elementList.add(localCool1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cdsc1"));
                            
                            
                                    if (localCdsc1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cdsc1 cannot be null!!");
                                    }
                                    elementList.add(localCdsc1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Furn1"));
                            
                            
                                    if (localFurn1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Furn1 cannot be null!!");
                                    }
                                    elementList.add(localFurn1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Fdsc1"));
                            
                            
                                    if (localFdsc1==null){
                                         throw new org.apache.axis2.databinding.ADBException("Fdsc1 cannot be null!!");
                                    }
                                    elementList.add(localFdsc1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Heat2"));
                            
                            
                                    if (localHeat2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Heat2 cannot be null!!");
                                    }
                                    elementList.add(localHeat2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hdsc2"));
                            
                            
                                    if (localHdsc2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hdsc2 cannot be null!!");
                                    }
                                    elementList.add(localHdsc2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Temp2"));
                            
                            
                                    if (localTemp2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Temp2 cannot be null!!");
                                    }
                                    elementList.add(localTemp2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Tdsc2"));
                            
                            
                                    if (localTdsc2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Tdsc2 cannot be null!!");
                                    }
                                    elementList.add(localTdsc2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hold2"));
                            
                            
                                    if (localHold2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hold2 cannot be null!!");
                                    }
                                    elementList.add(localHold2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hodsc2"));
                            
                            
                                    if (localHodsc2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hodsc2 cannot be null!!");
                                    }
                                    elementList.add(localHodsc2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cool2"));
                            
                            
                                    if (localCool2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cool2 cannot be null!!");
                                    }
                                    elementList.add(localCool2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cdsc2"));
                            
                            
                                    if (localCdsc2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cdsc2 cannot be null!!");
                                    }
                                    elementList.add(localCdsc2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Furn2"));
                            
                            
                                    if (localFurn2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Furn2 cannot be null!!");
                                    }
                                    elementList.add(localFurn2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Fdsc2"));
                            
                            
                                    if (localFdsc2==null){
                                         throw new org.apache.axis2.databinding.ADBException("Fdsc2 cannot be null!!");
                                    }
                                    elementList.add(localFdsc2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Heat3"));
                            
                            
                                    if (localHeat3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Heat3 cannot be null!!");
                                    }
                                    elementList.add(localHeat3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hdsc3"));
                            
                            
                                    if (localHdsc3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hdsc3 cannot be null!!");
                                    }
                                    elementList.add(localHdsc3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Temp3"));
                            
                            
                                    if (localTemp3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Temp3 cannot be null!!");
                                    }
                                    elementList.add(localTemp3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Tdsc3"));
                            
                            
                                    if (localTdsc3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Tdsc3 cannot be null!!");
                                    }
                                    elementList.add(localTdsc3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hold3"));
                            
                            
                                    if (localHold3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hold3 cannot be null!!");
                                    }
                                    elementList.add(localHold3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hodsc3"));
                            
                            
                                    if (localHodsc3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hodsc3 cannot be null!!");
                                    }
                                    elementList.add(localHodsc3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cool3"));
                            
                            
                                    if (localCool3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cool3 cannot be null!!");
                                    }
                                    elementList.add(localCool3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cdsc3"));
                            
                            
                                    if (localCdsc3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cdsc3 cannot be null!!");
                                    }
                                    elementList.add(localCdsc3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Furn3"));
                            
                            
                                    if (localFurn3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Furn3 cannot be null!!");
                                    }
                                    elementList.add(localFurn3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Fdsc3"));
                            
                            
                                    if (localFdsc3==null){
                                         throw new org.apache.axis2.databinding.ADBException("Fdsc3 cannot be null!!");
                                    }
                                    elementList.add(localFdsc3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Heat4"));
                            
                            
                                    if (localHeat4==null){
                                         throw new org.apache.axis2.databinding.ADBException("Heat4 cannot be null!!");
                                    }
                                    elementList.add(localHeat4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hdsc4"));
                            
                            
                                    if (localHdsc4==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hdsc4 cannot be null!!");
                                    }
                                    elementList.add(localHdsc4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Temp4"));
                            
                            
                                    if (localTemp4==null){
                                         throw new org.apache.axis2.databinding.ADBException("Temp4 cannot be null!!");
                                    }
                                    elementList.add(localTemp4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hold4"));
                            
                            
                                    if (localHold4==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hold4 cannot be null!!");
                                    }
                                    elementList.add(localHold4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Hodsc4"));
                            
                            
                                    if (localHodsc4==null){
                                         throw new org.apache.axis2.databinding.ADBException("Hodsc4 cannot be null!!");
                                    }
                                    elementList.add(localHodsc4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cool4"));
                            
                            
                                    if (localCool4==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cool4 cannot be null!!");
                                    }
                                    elementList.add(localCool4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Cdsc4"));
                            
                            
                                    if (localCdsc4==null){
                                         throw new org.apache.axis2.databinding.ADBException("Cdsc4 cannot be null!!");
                                    }
                                    elementList.add(localCdsc4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FeMax"));
                            
                            
                                    if (localFeMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("FeMax cannot be null!!");
                                    }
                                    elementList.add(localFeMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FeMin"));
                            
                            
                                    if (localFeMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("FeMin cannot be null!!");
                                    }
                                    elementList.add(localFeMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MoMin"));
                            
                            
                                    if (localMoMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("MoMin cannot be null!!");
                                    }
                                    elementList.add(localMoMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MoMax"));
                            
                            
                                    if (localMoMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("MoMax cannot be null!!");
                                    }
                                    elementList.add(localMoMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "VMin"));
                            
                            
                                    if (localVMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("VMin cannot be null!!");
                                    }
                                    elementList.add(localVMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "VMax"));
                            
                            
                                    if (localVMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("VMax cannot be null!!");
                                    }
                                    elementList.add(localVMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "AlMin"));
                            
                            
                                    if (localAlMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("AlMin cannot be null!!");
                                    }
                                    elementList.add(localAlMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "AlMax"));
                            
                            
                                    if (localAlMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("AlMax cannot be null!!");
                                    }
                                    elementList.add(localAlMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "NbMin"));
                            
                            
                                    if (localNbMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("NbMin cannot be null!!");
                                    }
                                    elementList.add(localNbMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "NbMax"));
                            
                            
                                    if (localNbMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("NbMax cannot be null!!");
                                    }
                                    elementList.add(localNbMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "WMin"));
                            
                            
                                    if (localWMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("WMin cannot be null!!");
                                    }
                                    elementList.add(localWMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "WMax"));
                            
                            
                                    if (localWMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("WMax cannot be null!!");
                                    }
                                    elementList.add(localWMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZnMin"));
                            
                            
                                    if (localZnMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZnMin cannot be null!!");
                                    }
                                    elementList.add(localZnMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZnMax"));
                            
                            
                                    if (localZnMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZnMax cannot be null!!");
                                    }
                                    elementList.add(localZnMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TiMin"));
                            
                            
                                    if (localTiMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("TiMin cannot be null!!");
                                    }
                                    elementList.add(localTiMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TiMax"));
                            
                            
                                    if (localTiMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("TiMax cannot be null!!");
                                    }
                                    elementList.add(localTiMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "NMin"));
                            
                            
                                    if (localNMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("NMin cannot be null!!");
                                    }
                                    elementList.add(localNMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "NMax"));
                            
                            
                                    if (localNMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("NMax cannot be null!!");
                                    }
                                    elementList.add(localNMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free1Min"));
                            
                            
                                    if (localFree1Min==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free1Min cannot be null!!");
                                    }
                                    elementList.add(localFree1Min);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free1Max"));
                            
                            
                                    if (localFree1Max==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free1Max cannot be null!!");
                                    }
                                    elementList.add(localFree1Max);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free2Min"));
                            
                            
                                    if (localFree2Min==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free2Min cannot be null!!");
                                    }
                                    elementList.add(localFree2Min);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free2Max"));
                            
                            
                                    if (localFree2Max==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free2Max cannot be null!!");
                                    }
                                    elementList.add(localFree2Max);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free3Min"));
                            
                            
                                    if (localFree3Min==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free3Min cannot be null!!");
                                    }
                                    elementList.add(localFree3Min);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free3Max"));
                            
                            
                                    if (localFree3Max==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free3Max cannot be null!!");
                                    }
                                    elementList.add(localFree3Max);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free1MinDes"));
                            
                            
                                    if (localFree1MinDes==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free1MinDes cannot be null!!");
                                    }
                                    elementList.add(localFree1MinDes);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free1MaxDes"));
                            
                            
                                    if (localFree1MaxDes==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free1MaxDes cannot be null!!");
                                    }
                                    elementList.add(localFree1MaxDes);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free2MinDes"));
                            
                            
                                    if (localFree2MinDes==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free2MinDes cannot be null!!");
                                    }
                                    elementList.add(localFree2MinDes);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free2MaxDes"));
                            
                            
                                    if (localFree2MaxDes==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free2MaxDes cannot be null!!");
                                    }
                                    elementList.add(localFree2MaxDes);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free3MinDes"));
                            
                            
                                    if (localFree3MinDes==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free3MinDes cannot be null!!");
                                    }
                                    elementList.add(localFree3MinDes);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Free3MaxDes"));
                            
                            
                                    if (localFree3MaxDes==null){
                                         throw new org.apache.axis2.databinding.ADBException("Free3MaxDes cannot be null!!");
                                    }
                                    elementList.add(localFree3MaxDes);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JTemp"));
                            
                            
                                    if (localJTemp==null){
                                         throw new org.apache.axis2.databinding.ADBException("JTemp cannot be null!!");
                                    }
                                    elementList.add(localJTemp);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JAvg"));
                            
                            
                                    if (localJAvg==null){
                                         throw new org.apache.axis2.databinding.ADBException("JAvg cannot be null!!");
                                    }
                                    elementList.add(localJAvg);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JMin"));
                            
                            
                                    if (localJMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("JMin cannot be null!!");
                                    }
                                    elementList.add(localJMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JTemp2"));
                            
                            
                                    if (localJTemp2==null){
                                         throw new org.apache.axis2.databinding.ADBException("JTemp2 cannot be null!!");
                                    }
                                    elementList.add(localJTemp2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JAvg2"));
                            
                            
                                    if (localJAvg2==null){
                                         throw new org.apache.axis2.databinding.ADBException("JAvg2 cannot be null!!");
                                    }
                                    elementList.add(localJAvg2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JMin2"));
                            
                            
                                    if (localJMin2==null){
                                         throw new org.apache.axis2.databinding.ADBException("JMin2 cannot be null!!");
                                    }
                                    elementList.add(localJMin2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JTemp3"));
                            
                            
                                    if (localJTemp3==null){
                                         throw new org.apache.axis2.databinding.ADBException("JTemp3 cannot be null!!");
                                    }
                                    elementList.add(localJTemp3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JAvg3"));
                            
                            
                                    if (localJAvg3==null){
                                         throw new org.apache.axis2.databinding.ADBException("JAvg3 cannot be null!!");
                                    }
                                    elementList.add(localJAvg3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JMin3"));
                            
                            
                                    if (localJMin3==null){
                                         throw new org.apache.axis2.databinding.ADBException("JMin3 cannot be null!!");
                                    }
                                    elementList.add(localJMin3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JTemp4"));
                            
                            
                                    if (localJTemp4==null){
                                         throw new org.apache.axis2.databinding.ADBException("JTemp4 cannot be null!!");
                                    }
                                    elementList.add(localJTemp4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JAvg4"));
                            
                            
                                    if (localJAvg4==null){
                                         throw new org.apache.axis2.databinding.ADBException("JAvg4 cannot be null!!");
                                    }
                                    elementList.add(localJAvg4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JMin4"));
                            
                            
                                    if (localJMin4==null){
                                         throw new org.apache.axis2.databinding.ADBException("JMin4 cannot be null!!");
                                    }
                                    elementList.add(localJMin4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JTemp5"));
                            
                            
                                    if (localJTemp5==null){
                                         throw new org.apache.axis2.databinding.ADBException("JTemp5 cannot be null!!");
                                    }
                                    elementList.add(localJTemp5);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JAvg5"));
                            
                            
                                    if (localJAvg5==null){
                                         throw new org.apache.axis2.databinding.ADBException("JAvg5 cannot be null!!");
                                    }
                                    elementList.add(localJAvg5);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JMin5"));
                            
                            
                                    if (localJMin5==null){
                                         throw new org.apache.axis2.databinding.ADBException("JMin5 cannot be null!!");
                                    }
                                    elementList.add(localJMin5);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JTemp6"));
                            
                            
                                    if (localJTemp6==null){
                                         throw new org.apache.axis2.databinding.ADBException("JTemp6 cannot be null!!");
                                    }
                                    elementList.add(localJTemp6);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JAvg6"));
                            
                            
                                    if (localJAvg6==null){
                                         throw new org.apache.axis2.databinding.ADBException("JAvg6 cannot be null!!");
                                    }
                                    elementList.add(localJAvg6);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "JMin6"));
                            
                            
                                    if (localJMin6==null){
                                         throw new org.apache.axis2.databinding.ADBException("JMin6 cannot be null!!");
                                    }
                                    elementList.add(localJMin6);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZiduanStr"));
                            
                            
                                    if (localZiduanStr==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZiduanStr cannot be null!!");
                                    }
                                    elementList.add(localZiduanStr);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Ys2Min"));
                            
                            
                                    if (localYs2Min==null){
                                         throw new org.apache.axis2.databinding.ADBException("Ys2Min cannot be null!!");
                                    }
                                    elementList.add(localYs2Min);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Ys2Max"));
                            
                            
                                    if (localYs2Max==null){
                                         throw new org.apache.axis2.databinding.ADBException("Ys2Max cannot be null!!");
                                    }
                                    elementList.add(localYs2Max);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Pt"));
                            
                            
                                    if (localPt==null){
                                         throw new org.apache.axis2.databinding.ADBException("Pt cannot be null!!");
                                    }
                                    elementList.add(localPt);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CeMax"));
                            
                            
                                    if (localCeMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("CeMax cannot be null!!");
                                    }
                                    elementList.add(localCeMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PrenMin"));
                            
                            
                                    if (localPrenMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("PrenMin cannot be null!!");
                                    }
                                    elementList.add(localPrenMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PrenB"));
                            
                            
                                    if (localPrenB==null){
                                         throw new org.apache.axis2.databinding.ADBException("PrenB cannot be null!!");
                                    }
                                    elementList.add(localPrenB);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZfeMin"));
                            
                            
                                    if (localZfeMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZfeMin cannot be null!!");
                                    }
                                    elementList.add(localZfeMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZfeMax"));
                            
                            
                                    if (localZfeMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZfeMax cannot be null!!");
                                    }
                                    elementList.add(localZfeMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZcaMin"));
                            
                            
                                    if (localZcaMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZcaMin cannot be null!!");
                                    }
                                    elementList.add(localZcaMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZcaMax"));
                            
                            
                                    if (localZcaMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZcaMax cannot be null!!");
                                    }
                                    elementList.add(localZcaMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "HMin"));
                            
                            
                                    if (localHMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("HMin cannot be null!!");
                                    }
                                    elementList.add(localHMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "HMax"));
                            
                            
                                    if (localHMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("HMax cannot be null!!");
                                    }
                                    elementList.add(localHMax);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "OMin"));
                            
                            
                                    if (localOMin==null){
                                         throw new org.apache.axis2.databinding.ADBException("OMin cannot be null!!");
                                    }
                                    elementList.add(localOMin);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "OMax"));
                            
                            
                                    if (localOMax==null){
                                         throw new org.apache.axis2.databinding.ADBException("OMax cannot be null!!");
                                    }
                                    elementList.add(localOMax);
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Zzcaizhi parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Zzcaizhi object =
                new Zzcaizhi();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"Zzcaizhi".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Zzcaizhi)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Mandt").equals(reader.getName())){
                                
                                                object.setMandt(Clnt3.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Zcz").equals(reader.getName())){
                                
                                                object.setZcz(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Vbeln").equals(reader.getName())){
                                
                                                object.setVbeln(Char10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Posnr").equals(reader.getName())){
                                
                                                object.setPosnr(Numeric6.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Std").equals(reader.getName())){
                                
                                                object.setStd(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Specificate").equals(reader.getName())){
                                
                                                object.setSpecificate(Char40.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Ce").equals(reader.getName())){
                                
                                                object.setCe(Char2.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Pren").equals(reader.getName())){
                                
                                                object.setPren(Char2.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Zdel").equals(reader.getName())){
                                
                                                object.setZdel(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cdate").equals(reader.getName())){
                                
                                                object.setCdate(Date10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Mdate").equals(reader.getName())){
                                
                                                object.setMdate(Date10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cuser").equals(reader.getName())){
                                
                                                object.setCuser(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Muser").equals(reader.getName())){
                                
                                                object.setMuser(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CMin").equals(reader.getName())){
                                
                                                object.setCMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CMax").equals(reader.getName())){
                                
                                                object.setCMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SiMin").equals(reader.getName())){
                                
                                                object.setSiMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SiMax").equals(reader.getName())){
                                
                                                object.setSiMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MnMin").equals(reader.getName())){
                                
                                                object.setMnMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MnMax").equals(reader.getName())){
                                
                                                object.setMnMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PMin").equals(reader.getName())){
                                
                                                object.setPMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PMax").equals(reader.getName())){
                                
                                                object.setPMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SMin").equals(reader.getName())){
                                
                                                object.setSMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SMax").equals(reader.getName())){
                                
                                                object.setSMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CrMin").equals(reader.getName())){
                                
                                                object.setCrMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CrMax").equals(reader.getName())){
                                
                                                object.setCrMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","NiMin").equals(reader.getName())){
                                
                                                object.setNiMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","NiMax").equals(reader.getName())){
                                
                                                object.setNiMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CuMin").equals(reader.getName())){
                                
                                                object.setCuMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CuMax").equals(reader.getName())){
                                
                                                object.setCuMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZrMin").equals(reader.getName())){
                                
                                                object.setZrMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZrMax").equals(reader.getName())){
                                
                                                object.setZrMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SnMin").equals(reader.getName())){
                                
                                                object.setSnMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SnMax").equals(reader.getName())){
                                
                                                object.setSnMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PbMin").equals(reader.getName())){
                                
                                                object.setPbMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PbMax").equals(reader.getName())){
                                
                                                object.setPbMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SbMin").equals(reader.getName())){
                                
                                                object.setSbMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SbMax").equals(reader.getName())){
                                
                                                object.setSbMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","AsMin").equals(reader.getName())){
                                
                                                object.setAsMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","AsMax").equals(reader.getName())){
                                
                                                object.setAsMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CoMin").equals(reader.getName())){
                                
                                                object.setCoMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CoMax").equals(reader.getName())){
                                
                                                object.setCoMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TaMin").equals(reader.getName())){
                                
                                                object.setTaMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TaMax").equals(reader.getName())){
                                
                                                object.setTaMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Ta1Min").equals(reader.getName())){
                                
                                                object.setTa1Min(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Ta1Max").equals(reader.getName())){
                                
                                                object.setTa1Max(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","User1Min").equals(reader.getName())){
                                
                                                object.setUser1Min(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","User1Max").equals(reader.getName())){
                                
                                                object.setUser1Max(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","User2Min").equals(reader.getName())){
                                
                                                object.setUser2Min(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","User2Max").equals(reader.getName())){
                                
                                                object.setUser2Max(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","User3Min").equals(reader.getName())){
                                
                                                object.setUser3Min(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","User3Max").equals(reader.getName())){
                                
                                                object.setUser3Max(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TsMin").equals(reader.getName())){
                                
                                                object.setTsMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TsMax").equals(reader.getName())){
                                
                                                object.setTsMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","YsMin").equals(reader.getName())){
                                
                                                object.setYsMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","YsMax").equals(reader.getName())){
                                
                                                object.setYsMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","EMin").equals(reader.getName())){
                                
                                                object.setEMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","EMax").equals(reader.getName())){
                                
                                                object.setEMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","RMin").equals(reader.getName())){
                                
                                                object.setRMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","RMax").equals(reader.getName())){
                                
                                                object.setRMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","HbMin").equals(reader.getName())){
                                
                                                object.setHbMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","HbMax").equals(reader.getName())){
                                
                                                object.setHbMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BMax").equals(reader.getName())){
                                
                                                object.setBMax(Quantum184.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BMin").equals(reader.getName())){
                                
                                                object.setBMin(Quantum184.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Heat1").equals(reader.getName())){
                                
                                                object.setHeat1(Char40.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hdsc1").equals(reader.getName())){
                                
                                                object.setHdsc1(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Temp1").equals(reader.getName())){
                                
                                                object.setTemp1(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Tdsc1").equals(reader.getName())){
                                
                                                object.setTdsc1(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hold1").equals(reader.getName())){
                                
                                                object.setHold1(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hodsc1").equals(reader.getName())){
                                
                                                object.setHodsc1(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cool1").equals(reader.getName())){
                                
                                                object.setCool1(Char21.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cdsc1").equals(reader.getName())){
                                
                                                object.setCdsc1(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Furn1").equals(reader.getName())){
                                
                                                object.setFurn1(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Fdsc1").equals(reader.getName())){
                                
                                                object.setFdsc1(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Heat2").equals(reader.getName())){
                                
                                                object.setHeat2(Char40.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hdsc2").equals(reader.getName())){
                                
                                                object.setHdsc2(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Temp2").equals(reader.getName())){
                                
                                                object.setTemp2(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Tdsc2").equals(reader.getName())){
                                
                                                object.setTdsc2(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hold2").equals(reader.getName())){
                                
                                                object.setHold2(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hodsc2").equals(reader.getName())){
                                
                                                object.setHodsc2(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cool2").equals(reader.getName())){
                                
                                                object.setCool2(Char21.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cdsc2").equals(reader.getName())){
                                
                                                object.setCdsc2(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Furn2").equals(reader.getName())){
                                
                                                object.setFurn2(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Fdsc2").equals(reader.getName())){
                                
                                                object.setFdsc2(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Heat3").equals(reader.getName())){
                                
                                                object.setHeat3(Char40.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hdsc3").equals(reader.getName())){
                                
                                                object.setHdsc3(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Temp3").equals(reader.getName())){
                                
                                                object.setTemp3(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Tdsc3").equals(reader.getName())){
                                
                                                object.setTdsc3(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hold3").equals(reader.getName())){
                                
                                                object.setHold3(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hodsc3").equals(reader.getName())){
                                
                                                object.setHodsc3(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cool3").equals(reader.getName())){
                                
                                                object.setCool3(Char21.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cdsc3").equals(reader.getName())){
                                
                                                object.setCdsc3(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Furn3").equals(reader.getName())){
                                
                                                object.setFurn3(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Fdsc3").equals(reader.getName())){
                                
                                                object.setFdsc3(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Heat4").equals(reader.getName())){
                                
                                                object.setHeat4(Char40.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hdsc4").equals(reader.getName())){
                                
                                                object.setHdsc4(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Temp4").equals(reader.getName())){
                                
                                                object.setTemp4(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hold4").equals(reader.getName())){
                                
                                                object.setHold4(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hodsc4").equals(reader.getName())){
                                
                                                object.setHodsc4(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cool4").equals(reader.getName())){
                                
                                                object.setCool4(Char21.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Cdsc4").equals(reader.getName())){
                                
                                                object.setCdsc4(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FeMax").equals(reader.getName())){
                                
                                                object.setFeMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FeMin").equals(reader.getName())){
                                
                                                object.setFeMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MoMin").equals(reader.getName())){
                                
                                                object.setMoMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MoMax").equals(reader.getName())){
                                
                                                object.setMoMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","VMin").equals(reader.getName())){
                                
                                                object.setVMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","VMax").equals(reader.getName())){
                                
                                                object.setVMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","AlMin").equals(reader.getName())){
                                
                                                object.setAlMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","AlMax").equals(reader.getName())){
                                
                                                object.setAlMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","NbMin").equals(reader.getName())){
                                
                                                object.setNbMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","NbMax").equals(reader.getName())){
                                
                                                object.setNbMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","WMin").equals(reader.getName())){
                                
                                                object.setWMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","WMax").equals(reader.getName())){
                                
                                                object.setWMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZnMin").equals(reader.getName())){
                                
                                                object.setZnMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZnMax").equals(reader.getName())){
                                
                                                object.setZnMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TiMin").equals(reader.getName())){
                                
                                                object.setTiMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TiMax").equals(reader.getName())){
                                
                                                object.setTiMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","NMin").equals(reader.getName())){
                                
                                                object.setNMin(Quantum184.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","NMax").equals(reader.getName())){
                                
                                                object.setNMax(Quantum184.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free1Min").equals(reader.getName())){
                                
                                                object.setFree1Min(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free1Max").equals(reader.getName())){
                                
                                                object.setFree1Max(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free2Min").equals(reader.getName())){
                                
                                                object.setFree2Min(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free2Max").equals(reader.getName())){
                                
                                                object.setFree2Max(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free3Min").equals(reader.getName())){
                                
                                                object.setFree3Min(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free3Max").equals(reader.getName())){
                                
                                                object.setFree3Max(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free1MinDes").equals(reader.getName())){
                                
                                                object.setFree1MinDes(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free1MaxDes").equals(reader.getName())){
                                
                                                object.setFree1MaxDes(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free2MinDes").equals(reader.getName())){
                                
                                                object.setFree2MinDes(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free2MaxDes").equals(reader.getName())){
                                
                                                object.setFree2MaxDes(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free3MinDes").equals(reader.getName())){
                                
                                                object.setFree3MinDes(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Free3MaxDes").equals(reader.getName())){
                                
                                                object.setFree3MaxDes(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JTemp").equals(reader.getName())){
                                
                                                object.setJTemp(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JAvg").equals(reader.getName())){
                                
                                                object.setJAvg(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JMin").equals(reader.getName())){
                                
                                                object.setJMin(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JTemp2").equals(reader.getName())){
                                
                                                object.setJTemp2(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JAvg2").equals(reader.getName())){
                                
                                                object.setJAvg2(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JMin2").equals(reader.getName())){
                                
                                                object.setJMin2(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JTemp3").equals(reader.getName())){
                                
                                                object.setJTemp3(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JAvg3").equals(reader.getName())){
                                
                                                object.setJAvg3(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JMin3").equals(reader.getName())){
                                
                                                object.setJMin3(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JTemp4").equals(reader.getName())){
                                
                                                object.setJTemp4(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JAvg4").equals(reader.getName())){
                                
                                                object.setJAvg4(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JMin4").equals(reader.getName())){
                                
                                                object.setJMin4(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JTemp5").equals(reader.getName())){
                                
                                                object.setJTemp5(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JAvg5").equals(reader.getName())){
                                
                                                object.setJAvg5(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JMin5").equals(reader.getName())){
                                
                                                object.setJMin5(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JTemp6").equals(reader.getName())){
                                
                                                object.setJTemp6(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JAvg6").equals(reader.getName())){
                                
                                                object.setJAvg6(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","JMin6").equals(reader.getName())){
                                
                                                object.setJMin6(Char8.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZiduanStr").equals(reader.getName())){
                                
                                                object.setZiduanStr(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Ys2Min").equals(reader.getName())){
                                
                                                object.setYs2Min(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Ys2Max").equals(reader.getName())){
                                
                                                object.setYs2Max(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Pt").equals(reader.getName())){
                                
                                                object.setPt(Char2.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CeMax").equals(reader.getName())){
                                
                                                object.setCeMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PrenMin").equals(reader.getName())){
                                
                                                object.setPrenMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PrenB").equals(reader.getName())){
                                
                                                object.setPrenB(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZfeMin").equals(reader.getName())){
                                
                                                object.setZfeMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZfeMax").equals(reader.getName())){
                                
                                                object.setZfeMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZcaMin").equals(reader.getName())){
                                
                                                object.setZcaMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZcaMax").equals(reader.getName())){
                                
                                                object.setZcaMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","HMin").equals(reader.getName())){
                                
                                                object.setHMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","HMax").equals(reader.getName())){
                                
                                                object.setHMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","OMin").equals(reader.getName())){
                                
                                                object.setOMin(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","OMax").equals(reader.getName())){
                                
                                                object.setOMax(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                              
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Char10
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char10",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char10
                        */

                        
                                    protected java.lang.String localChar10 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar10(){
                               return localChar10;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char10
                               */
                               public void setChar10(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 10)  ) {
                                                this.localChar10=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar10.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Char10.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":char10",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char10",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar10==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar10);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar10)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char10 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char10 returnValue = new  Char10();
                    
                            returnValue.setChar10(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char10 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char10.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char10.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char10 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char10 object =
                new Char10();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChar10(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Char40
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char40",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char40
                        */

                        
                                    protected java.lang.String localChar40 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar40(){
                               return localChar40;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char40
                               */
                               public void setChar40(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 40)  ) {
                                                this.localChar40=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar40.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Char40.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":char40",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char40",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar40==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar40);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar40)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char40 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char40 returnValue = new  Char40();
                    
                            returnValue.setChar40(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char40 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char40.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char40.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char40 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char40 object =
                new Char40();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChar40(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Char2
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char2",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char2
                        */

                        
                                    protected java.lang.String localChar2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar2(){
                               return localChar2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char2
                               */
                               public void setChar2(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 2)  ) {
                                                this.localChar2=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar2.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Char2.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":char2",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char2",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar2==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar2);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar2)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char2 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char2 returnValue = new  Char2();
                    
                            returnValue.setChar2(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char2 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char2.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char2.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char2 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char2 object =
                new Char2();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChar2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Char25
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char25",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char25
                        */

                        
                                    protected java.lang.String localChar25 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar25(){
                               return localChar25;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char25
                               */
                               public void setChar25(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 25)  ) {
                                                this.localChar25=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar25.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Char25.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":char25",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char25",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar25==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar25);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar25)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char25 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char25 returnValue = new  Char25();
                    
                            returnValue.setChar25(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char25 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char25.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char25.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char25 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char25 object =
                new Char25();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChar25(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Char15
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char15",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char15
                        */

                        
                                    protected java.lang.String localChar15 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar15(){
                               return localChar15;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char15
                               */
                               public void setChar15(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 15)  ) {
                                                this.localChar15=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar15.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Char15.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":char15",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char15",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar15==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar15);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar15)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char15 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char15 returnValue = new  Char15();
                    
                            returnValue.setChar15(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char15 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char15.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char15.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char15 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char15 object =
                new Char15();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChar15(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class TableOfZzcaizhi
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = TableOfZzcaizhi
                Namespace URI = urn:sap-com:document:sap:soap:functions:mc-style
                Namespace Prefix = ns2
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:soap:functions:mc-style")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Item
                        * This was an Array!
                        */

                        
                                    protected Zzcaizhi[] localItem ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localItemTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return Zzcaizhi[]
                           */
                           public  Zzcaizhi[] getItem(){
                               return localItem;
                           }

                           
                        


                               
                              /**
                               * validate the array for Item
                               */
                              protected void validateItem(Zzcaizhi[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Item
                              */
                              public void setItem(Zzcaizhi[] param){
                              
                                   validateItem(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localItemTracker = true;
                                          } else {
                                             localItemTracker = false;
                                                 
                                          }
                                      
                                      this.localItem=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param Zzcaizhi
                             */
                             public void addItem(Zzcaizhi param){
                                   if (localItem == null){
                                   localItem = new Zzcaizhi[]{};
                                   }

                            
                                 //update the setting tracker
                                localItemTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localItem);
                               list.add(param);
                               this.localItem =
                             (Zzcaizhi[])list.toArray(
                            new Zzcaizhi[list.size()]);

                             }
                             

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       TableOfZzcaizhi.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:soap:functions:mc-style");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":TableOfZzcaizhi",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "TableOfZzcaizhi",
                           xmlWriter);
                   }

               
                   }
                if (localItemTracker){
                                       if (localItem!=null){
                                            for (int i = 0;i < localItem.length;i++){
                                                if (localItem[i] != null){
                                                 localItem[i].serialize(new javax.xml.namespace.QName("","item"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("item cannot be null!!");
                                        
                                    }
                                 }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localItemTracker){
                             if (localItem!=null) {
                                 for (int i = 0;i < localItem.length;i++){

                                    if (localItem[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "item"));
                                         elementList.add(localItem[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("item cannot be null!!");
                                    
                             }

                        }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static TableOfZzcaizhi parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            TableOfZzcaizhi object =
                new TableOfZzcaizhi();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"TableOfZzcaizhi".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (TableOfZzcaizhi)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                        java.util.ArrayList list1 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","item").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list1.add(Zzcaizhi.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone1 = false;
                                                        while(!loopDone1){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone1 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","item").equals(reader.getName())){
                                                                    list1.add(Zzcaizhi.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone1 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setItem((Zzcaizhi[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                Zzcaizhi.class,
                                                                list1));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Clnt3
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "clnt3",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Clnt3
                        */

                        
                                    protected java.lang.String localClnt3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getClnt3(){
                               return localClnt3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Clnt3
                               */
                               public void setClnt3(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 3)  ) {
                                                this.localClnt3=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localClnt3.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Clnt3.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":clnt3",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "clnt3",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localClnt3==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localClnt3);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localClnt3)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Clnt3 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Clnt3 returnValue = new  Clnt3();
                    
                            returnValue.setClnt3(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Clnt3 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Clnt3.Factory.fromString(content,namespaceUri);
                    } else {
                       return Clnt3.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Clnt3 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Clnt3 object =
                new Clnt3();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setClnt3(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "quantum18.4".equals(typeName)){
                   
                            return  Quantum184.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:soap:functions:mc-style".equals(namespaceURI) &&
                  "Zzcaizhi".equals(typeName)){
                   
                            return  Zzcaizhi.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char25".equals(typeName)){
                   
                            return  Char25.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char40".equals(typeName)){
                   
                            return  Char40.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:soap:functions:mc-style".equals(namespaceURI) &&
                  "TableOfZzcaizhi".equals(typeName)){
                   
                            return  TableOfZzcaizhi.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char20".equals(typeName)){
                   
                            return  Char20.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "quantum18.3".equals(typeName)){
                   
                            return  Quantum183.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char21".equals(typeName)){
                   
                            return  Char21.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "clnt3".equals(typeName)){
                   
                            return  Clnt3.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "date10".equals(typeName)){
                   
                            return  Date10.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char8".equals(typeName)){
                   
                            return  Char8.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char2".equals(typeName)){
                   
                            return  Char2.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char1".equals(typeName)){
                   
                            return  Char1.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char15".equals(typeName)){
                   
                            return  Char15.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char10".equals(typeName)){
                   
                            return  Char10.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "numeric6".equals(typeName)){
                   
                            return  Numeric6.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    
        public static class Numeric6
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "numeric6",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Numeric6
                        */

                        
                                    protected java.lang.String localNumeric6 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNumeric6(){
                               return localNumeric6;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Numeric6
                               */
                               public void setNumeric6(java.lang.String param){
                            
                                            if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches("\\d*")) {
                                                this.localNumeric6=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localNumeric6.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Numeric6.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":numeric6",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "numeric6",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localNumeric6==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localNumeric6);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNumeric6)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Numeric6 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Numeric6 returnValue = new  Numeric6();
                    
                            returnValue.setNumeric6(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Numeric6 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Numeric6.Factory.fromString(content,namespaceUri);
                    } else {
                       return Numeric6.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Numeric6 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Numeric6 object =
                new Numeric6();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNumeric6(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Char8
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char8",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char8
                        */

                        
                                    protected java.lang.String localChar8 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar8(){
                               return localChar8;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char8
                               */
                               public void setChar8(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 8)  ) {
                                                this.localChar8=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar8.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Char8.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":char8",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char8",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar8==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar8);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar8)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char8 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char8 returnValue = new  Char8();
                    
                            returnValue.setChar8(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char8 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char8.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char8.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char8 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char8 object =
                new Char8();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChar8(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Quantum183
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "quantum18.3",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Quantum183
                        */

                        
                                    protected java.math.BigDecimal localQuantum183 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getQuantum183(){
                               return localQuantum183;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Quantum183
                               */
                               public void setQuantum183(java.math.BigDecimal param){
                            
                                             this.localQuantum183=param;
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localQuantum183.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Quantum183.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":quantum18.3",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "quantum18.3",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localQuantum183==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuantum183));
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuantum183)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Quantum183 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Quantum183 returnValue = new  Quantum183();
                    
                            returnValue.setQuantum183(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(value));
                        

                    return returnValue;
                }

                public static Quantum183 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Quantum183.Factory.fromString(content,namespaceUri);
                    } else {
                       return Quantum183.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Quantum183 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Quantum183 object =
                new Quantum183();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQuantum183(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Quantum184
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "quantum18.4",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Quantum184
                        */

                        
                                    protected java.math.BigDecimal localQuantum184 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getQuantum184(){
                               return localQuantum184;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Quantum184
                               */
                               public void setQuantum184(java.math.BigDecimal param){
                            
                                             this.localQuantum184=param;
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localQuantum184.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Quantum184.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":quantum18.4",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "quantum18.4",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localQuantum184==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuantum184));
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuantum184)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Quantum184 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Quantum184 returnValue = new  Quantum184();
                    
                            returnValue.setQuantum184(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(value));
                        

                    return returnValue;
                }

                public static Quantum184 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Quantum184.Factory.fromString(content,namespaceUri);
                    } else {
                       return Quantum184.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Quantum184 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Quantum184 object =
                new Quantum184();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQuantum184(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
        public static class Date10
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "date10",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Date10
                        */

                        
                                    protected java.lang.String localDate10 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDate10(){
                               return localDate10;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Date10
                               */
                               public void setDate10(java.lang.String param){
                            
                                            if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")) {
                                                this.localDate10=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localDate10.toString();
                                    
                            }
                        

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Date10.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                
                //We can safely assume an element has only one type associated with it
                
                            java.lang.String namespace = parentQName.getNamespaceURI();
                            java.lang.String localName = parentQName.getLocalPart();
                        
                            if (! namespace.equals("")) {
                                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                                if (prefix == null) {
                                    prefix = generatePrefix(namespace);

                                    xmlWriter.writeStartElement(prefix, localName, namespace);
                                    xmlWriter.writeNamespace(prefix, namespace);
                                    xmlWriter.setPrefix(prefix, namespace);

                                } else {
                                    xmlWriter.writeStartElement(namespace, localName);
                                }

                            } else {
                                xmlWriter.writeStartElement(localName);
                            }

                            // add the type details if this is used in a simple type
                               if (serializeType){
                                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           namespacePrefix+":date10",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "date10",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localDate10==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localDate10);
                                            
                                         }
                                    
                            xmlWriter.writeEndElement();

                    

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                
                //We can safely assume an element has only one type associated with it
                 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                            new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDate10)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Date10 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Date10 returnValue = new  Date10();
                    
                            returnValue.setDate10(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Date10 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Date10.Factory.fromString(content,namespaceUri);
                    } else {
                       return Date10.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Date10 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Date10 object =
                new Date10();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                    
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDate10(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          
            private  org.apache.axiom.om.OMElement  toOM(Zmm_get_mtrstdStub.ZmmGetMtrstd param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(Zmm_get_mtrstdStub.ZmmGetMtrstd.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(Zmm_get_mtrstdStub.ZmmGetMtrstdResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(Zmm_get_mtrstdStub.ZmmGetMtrstdResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, Zmm_get_mtrstdStub.ZmmGetMtrstd param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(Zmm_get_mtrstdStub.ZmmGetMtrstd.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (Zmm_get_mtrstdStub.ZmmGetMtrstd.class.equals(type)){
                
                           return Zmm_get_mtrstdStub.ZmmGetMtrstd.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (Zmm_get_mtrstdStub.ZmmGetMtrstdResponse.class.equals(type)){
                
                           return Zmm_get_mtrstdStub.ZmmGetMtrstdResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   