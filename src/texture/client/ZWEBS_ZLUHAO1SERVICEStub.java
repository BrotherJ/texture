
/**
 * ZWEBS_ZLUHAO1SERVICEStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */
        package texture.client;

        

        /*
        *  ZWEBS_ZLUHAO1SERVICEStub java implementation
        */

        
        public class ZWEBS_ZLUHAO1SERVICEStub extends org.apache.axis2.client.Stub
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
     _service = new org.apache.axis2.description.AxisService("ZWEBS_ZLUHAO1SERVICE" + getUniqueSuffix());
//     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZWEBS_ZLUHAO1"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         


    }

    /**
      *Constructor that takes in a configContext
      */

    public ZWEBS_ZLUHAO1SERVICEStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public ZWEBS_ZLUHAO1SERVICEStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public ZWEBS_ZLUHAO1SERVICEStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zluhao1/800/zwebs_zluhao1service/zwebs_zluhao1" );
                
    }

    /**
     * Default Constructor
     */
    public ZWEBS_ZLUHAO1SERVICEStub() throws org.apache.axis2.AxisFault {
        
                    this("http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zluhao1/800/zwebs_zluhao1service/zwebs_zluhao1" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public ZWEBS_ZLUHAO1SERVICEStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see ZWEBS_ZLUHAO1SERVICE#ZWEBS_ZLUHAO1
                     * @param zWEBS_ZLUHAO10
                    
                     */

                    

                            public  ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response ZWEBS_ZLUHAO1(

                            ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1 zWEBS_ZLUHAO10)
                        

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
                                                    zWEBS_ZLUHAO10,
                                                    optimizeContent(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
                                                    "ZWEBS_ZLUHAO1")));
                                                
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
                                             ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response)object;
                                   
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
                * @see ZWEBS_ZLUHAO1SERVICE#startZWEBS_ZLUHAO1
                    * @param zWEBS_ZLUHAO10
                
                */
                public  void startZWEBS_ZLUHAO1(

                 ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1 zWEBS_ZLUHAO10,

                  final ZWEBS_ZLUHAO1SERVICECallbackHandler callback)

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
                                                    zWEBS_ZLUHAO10,
                                                    optimizeContent(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
                                                    "ZWEBS_ZLUHAO1")));
                                                
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
                                                                         ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultZWEBS_ZLUHAO1(
                                        (ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorZWEBS_ZLUHAO1(e);
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
													
					
										            callback.receiveErrorZWEBS_ZLUHAO1(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZWEBS_ZLUHAO1(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZWEBS_ZLUHAO1(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZWEBS_ZLUHAO1(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZWEBS_ZLUHAO1(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZWEBS_ZLUHAO1(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZWEBS_ZLUHAO1(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorZWEBS_ZLUHAO1(f);
                                            }
									    } else {
										    callback.receiveErrorZWEBS_ZLUHAO1(f);
									    }
									} else {
									    callback.receiveErrorZWEBS_ZLUHAO1(f);
									}
								} else {
								    callback.receiveErrorZWEBS_ZLUHAO1(error);
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
                                    callback.receiveErrorZWEBS_ZLUHAO1(axisFault);
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
     //http://ERPPRD3.neway.com.cn:8000/sap/bc/srt/rfc/sap/zwebs_zluhao1/800/zwebs_zluhao1service/zwebs_zluhao1
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
           
          
        public static class Char100
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char100",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char100
                        */

                        
                                    protected java.lang.String localChar100 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar100(){
                               return localChar100;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char100
                               */
                               public void setChar100(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 100)  ) {
                                                this.localChar100=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar100.toString();
                                    
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
                       Char100.this.serialize(MY_QNAME,factory,xmlWriter);
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
                                           namespacePrefix+":char100",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char100",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar100==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar100);
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar100)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char100 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char100 returnValue = new  Char100();
                    
                            returnValue.setChar100(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char100 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char100.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char100.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char100 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char100 object =
                new Char100();

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
                                    
                                              object.setChar100(
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
           
          
        public static class ZWEBS_ZLUHAO1Response
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "ZWEBS_ZLUHAO1Response",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for L_MSG
                        */

                        
                                    protected Char10 localL_MSG ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char10
                           */
                           public  Char10 getL_MSG(){
                               return localL_MSG;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param L_MSG
                               */
                               public void setL_MSG(Char10 param){
                            
                                            this.localL_MSG=param;
                                    

                               }
                            

                        /**
                        * field for ZMTR_ZHZZ
                        */

                        
                                    protected TABLE_OF_ZHZZ localZMTR_ZHZZ ;
                                

                           /**
                           * Auto generated getter method
                           * @return TABLE_OF_ZHZZ
                           */
                           public  TABLE_OF_ZHZZ getZMTR_ZHZZ(){
                               return localZMTR_ZHZZ;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZMTR_ZHZZ
                               */
                               public void setZMTR_ZHZZ(TABLE_OF_ZHZZ param){
                            
                                            this.localZMTR_ZHZZ=param;
                                    

                               }
                            

                        /**
                        * field for ZMTR_ZLUHAO
                        */

                        
                                    protected TABLE_OF_ZLUHAO localZMTR_ZLUHAO ;
                                

                           /**
                           * Auto generated getter method
                           * @return TABLE_OF_ZLUHAO
                           */
                           public  TABLE_OF_ZLUHAO getZMTR_ZLUHAO(){
                               return localZMTR_ZLUHAO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZMTR_ZLUHAO
                               */
                               public void setZMTR_ZLUHAO(TABLE_OF_ZLUHAO param){
                            
                                            this.localZMTR_ZLUHAO=param;
                                    

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
                       ZWEBS_ZLUHAO1Response.this.serialize(MY_QNAME,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ZWEBS_ZLUHAO1Response",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZWEBS_ZLUHAO1Response",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localL_MSG==null){
                                                 throw new org.apache.axis2.databinding.ADBException("L_MSG cannot be null!!");
                                            }
                                           localL_MSG.serialize(new javax.xml.namespace.QName("","L_MSG"),
                                               factory,xmlWriter);
                                        
                                            if (localZMTR_ZHZZ==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZMTR_ZHZZ cannot be null!!");
                                            }
                                           localZMTR_ZHZZ.serialize(new javax.xml.namespace.QName("","ZMTR_ZHZZ"),
                                               factory,xmlWriter);
                                        
                                            if (localZMTR_ZLUHAO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZMTR_ZLUHAO cannot be null!!");
                                            }
                                           localZMTR_ZLUHAO.serialize(new javax.xml.namespace.QName("","ZMTR_ZLUHAO"),
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
                                                                      "L_MSG"));
                            
                            
                                    if (localL_MSG==null){
                                         throw new org.apache.axis2.databinding.ADBException("L_MSG cannot be null!!");
                                    }
                                    elementList.add(localL_MSG);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZMTR_ZHZZ"));
                            
                            
                                    if (localZMTR_ZHZZ==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZMTR_ZHZZ cannot be null!!");
                                    }
                                    elementList.add(localZMTR_ZHZZ);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZMTR_ZLUHAO"));
                            
                            
                                    if (localZMTR_ZLUHAO==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZMTR_ZLUHAO cannot be null!!");
                                    }
                                    elementList.add(localZMTR_ZLUHAO);
                                

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
        public static ZWEBS_ZLUHAO1Response parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZWEBS_ZLUHAO1Response object =
                new ZWEBS_ZLUHAO1Response();

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
                    
                            if (!"ZWEBS_ZLUHAO1Response".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZWEBS_ZLUHAO1Response)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","L_MSG").equals(reader.getName())){
                                
                                                object.setL_MSG(Char10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZMTR_ZHZZ").equals(reader.getName())){
                                
                                                object.setZMTR_ZHZZ(TABLE_OF_ZHZZ.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZMTR_ZLUHAO").equals(reader.getName())){
                                
                                                object.setZMTR_ZLUHAO(TABLE_OF_ZLUHAO.Factory.parse(reader));
                                              
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
           
          
        public static class Char200
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char200",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char200
                        */

                        
                                    protected java.lang.String localChar200 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar200(){
                               return localChar200;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char200
                               */
                               public void setChar200(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 200)  ) {
                                                this.localChar200=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar200.toString();
                                    
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
                       Char200.this.serialize(MY_QNAME,factory,xmlWriter);
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
                                           namespacePrefix+":char200",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char200",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar200==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar200);
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar200)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char200 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char200 returnValue = new  Char200();
                    
                            returnValue.setChar200(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char200 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char200.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char200.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char200 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char200 object =
                new Char200();

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
                                    
                                              object.setChar200(
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
           
          
        public static class Char5
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char5",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char5
                        */

                        
                                    protected java.lang.String localChar5 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar5(){
                               return localChar5;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char5
                               */
                               public void setChar5(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 5)  ) {
                                                this.localChar5=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar5.toString();
                                    
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
                       Char5.this.serialize(MY_QNAME,factory,xmlWriter);
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
                                           namespacePrefix+":char5",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char5",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar5==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar5);
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar5)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char5 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char5 returnValue = new  Char5();
                    
                            returnValue.setChar5(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char5 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char5.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char5.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char5 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char5 object =
                new Char5();

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
                                    
                                              object.setChar5(
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
           
          
        public static class Quantum181
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "quantum18.1",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Quantum181
                        */

                        
                                    protected java.math.BigDecimal localQuantum181 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getQuantum181(){
                               return localQuantum181;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Quantum181
                               */
                               public void setQuantum181(java.math.BigDecimal param){
                            
                                             this.localQuantum181=param;
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localQuantum181.toString();
                                    
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
                       Quantum181.this.serialize(MY_QNAME,factory,xmlWriter);
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
                                           namespacePrefix+":quantum18.1",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "quantum18.1",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localQuantum181==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuantum181));
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuantum181)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Quantum181 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Quantum181 returnValue = new  Quantum181();
                    
                            returnValue.setQuantum181(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(value));
                        

                    return returnValue;
                }

                public static Quantum181 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Quantum181.Factory.fromString(content,namespaceUri);
                    } else {
                       return Quantum181.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Quantum181 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Quantum181 object =
                new Quantum181();

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
                                    
                                              object.setQuantum181(
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
           
          
        public static class Quantum180
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "quantum18.0",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Quantum180
                        */

                        
                                    protected java.math.BigDecimal localQuantum180 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getQuantum180(){
                               return localQuantum180;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Quantum180
                               */
                               public void setQuantum180(java.math.BigDecimal param){
                            
                                             this.localQuantum180=param;
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localQuantum180.toString();
                                    
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
                       Quantum180.this.serialize(MY_QNAME,factory,xmlWriter);
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
                                           namespacePrefix+":quantum18.0",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "quantum18.0",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localQuantum180==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuantum180));
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuantum180)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Quantum180 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Quantum180 returnValue = new  Quantum180();
                    
                            returnValue.setQuantum180(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(value));
                        

                    return returnValue;
                }

                public static Quantum180 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Quantum180.Factory.fromString(content,namespaceUri);
                    } else {
                       return Quantum180.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Quantum180 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Quantum180 object =
                new Quantum180();

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
                                    
                                              object.setQuantum180(
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
           
          
        public static class ZLUHAO
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ZLUHAO
                Namespace URI = urn:sap-com:document:sap:rfc:functions
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for MANDT
                        */

                        
                                    protected Clnt3 localMANDT ;
                                

                           /**
                           * Auto generated getter method
                           * @return Clnt3
                           */
                           public  Clnt3 getMANDT(){
                               return localMANDT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MANDT
                               */
                               public void setMANDT(Clnt3 param){
                            
                                            this.localMANDT=param;
                                    

                               }
                            

                        /**
                        * field for ZCZ
                        */

                        
                                    protected Char25 localZCZ ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getZCZ(){
                               return localZCZ;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZCZ
                               */
                               public void setZCZ(Char25 param){
                            
                                            this.localZCZ=param;
                                    

                               }
                            

                        /**
                        * field for LUHAO
                        */

                        
                                    protected Char20 localLUHAO ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getLUHAO(){
                               return localLUHAO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LUHAO
                               */
                               public void setLUHAO(Char20 param){
                            
                                            this.localLUHAO=param;
                                    

                               }
                            

                        /**
                        * field for STOCH
                        */

                        
                                    protected Char6 localSTOCH ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char6
                           */
                           public  Char6 getSTOCH(){
                               return localSTOCH;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param STOCH
                               */
                               public void setSTOCH(Char6 param){
                            
                                            this.localSTOCH=param;
                                    

                               }
                            

                        /**
                        * field for ZDEL
                        */

                        
                                    protected Char1 localZDEL ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getZDEL(){
                               return localZDEL;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZDEL
                               */
                               public void setZDEL(Char1 param){
                            
                                            this.localZDEL=param;
                                    

                               }
                            

                        /**
                        * field for CUSER
                        */

                        
                                    protected Char20 localCUSER ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getCUSER(){
                               return localCUSER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CUSER
                               */
                               public void setCUSER(Char20 param){
                            
                                            this.localCUSER=param;
                                    

                               }
                            

                        /**
                        * field for CDATE
                        */

                        
                                    protected Date10 localCDATE ;
                                

                           /**
                           * Auto generated getter method
                           * @return Date10
                           */
                           public  Date10 getCDATE(){
                               return localCDATE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CDATE
                               */
                               public void setCDATE(Date10 param){
                            
                                            this.localCDATE=param;
                                    

                               }
                            

                        /**
                        * field for CTIME
                        */

                        
                                    protected Time localCTIME ;
                                

                           /**
                           * Auto generated getter method
                           * @return Time
                           */
                           public  Time getCTIME(){
                               return localCTIME;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CTIME
                               */
                               public void setCTIME(Time param){
                            
                                            this.localCTIME=param;
                                    

                               }
                            

                        /**
                        * field for MUSER
                        */

                        
                                    protected Char20 localMUSER ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getMUSER(){
                               return localMUSER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MUSER
                               */
                               public void setMUSER(Char20 param){
                            
                                            this.localMUSER=param;
                                    

                               }
                            

                        /**
                        * field for MDATE
                        */

                        
                                    protected Date10 localMDATE ;
                                

                           /**
                           * Auto generated getter method
                           * @return Date10
                           */
                           public  Date10 getMDATE(){
                               return localMDATE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MDATE
                               */
                               public void setMDATE(Date10 param){
                            
                                            this.localMDATE=param;
                                    

                               }
                            

                        /**
                        * field for MTIME
                        */

                        
                                    protected Time localMTIME ;
                                

                           /**
                           * Auto generated getter method
                           * @return Time
                           */
                           public  Time getMTIME(){
                               return localMTIME;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MTIME
                               */
                               public void setMTIME(Time param){
                            
                                            this.localMTIME=param;
                                    

                               }
                            

                        /**
                        * field for ZC
                        */

                        
                                    protected Quantum183 localZC ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZC(){
                               return localZC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZC
                               */
                               public void setZC(Quantum183 param){
                            
                                            this.localZC=param;
                                    

                               }
                            

                        /**
                        * field for ZSI
                        */

                        
                                    protected Quantum183 localZSI ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZSI(){
                               return localZSI;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZSI
                               */
                               public void setZSI(Quantum183 param){
                            
                                            this.localZSI=param;
                                    

                               }
                            

                        /**
                        * field for ZMN
                        */

                        
                                    protected Quantum183 localZMN ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZMN(){
                               return localZMN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZMN
                               */
                               public void setZMN(Quantum183 param){
                            
                                            this.localZMN=param;
                                    

                               }
                            

                        /**
                        * field for ZP
                        */

                        
                                    protected Quantum183 localZP ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZP(){
                               return localZP;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZP
                               */
                               public void setZP(Quantum183 param){
                            
                                            this.localZP=param;
                                    

                               }
                            

                        /**
                        * field for ZS
                        */

                        
                                    protected Quantum183 localZS ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZS(){
                               return localZS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZS
                               */
                               public void setZS(Quantum183 param){
                            
                                            this.localZS=param;
                                    

                               }
                            

                        /**
                        * field for ZCR
                        */

                        
                                    protected Quantum183 localZCR ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZCR(){
                               return localZCR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZCR
                               */
                               public void setZCR(Quantum183 param){
                            
                                            this.localZCR=param;
                                    

                               }
                            

                        /**
                        * field for ZNI
                        */

                        
                                    protected Quantum183 localZNI ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZNI(){
                               return localZNI;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZNI
                               */
                               public void setZNI(Quantum183 param){
                            
                                            this.localZNI=param;
                                    

                               }
                            

                        /**
                        * field for ZMO
                        */

                        
                                    protected Quantum183 localZMO ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZMO(){
                               return localZMO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZMO
                               */
                               public void setZMO(Quantum183 param){
                            
                                            this.localZMO=param;
                                    

                               }
                            

                        /**
                        * field for ZCU
                        */

                        
                                    protected Quantum183 localZCU ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZCU(){
                               return localZCU;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZCU
                               */
                               public void setZCU(Quantum183 param){
                            
                                            this.localZCU=param;
                                    

                               }
                            

                        /**
                        * field for ZV
                        */

                        
                                    protected Quantum183 localZV ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZV(){
                               return localZV;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZV
                               */
                               public void setZV(Quantum183 param){
                            
                                            this.localZV=param;
                                    

                               }
                            

                        /**
                        * field for ZAL
                        */

                        
                                    protected Quantum183 localZAL ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZAL(){
                               return localZAL;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZAL
                               */
                               public void setZAL(Quantum183 param){
                            
                                            this.localZAL=param;
                                    

                               }
                            

                        /**
                        * field for ZNB
                        */

                        
                                    protected Quantum183 localZNB ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZNB(){
                               return localZNB;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZNB
                               */
                               public void setZNB(Quantum183 param){
                            
                                            this.localZNB=param;
                                    

                               }
                            

                        /**
                        * field for ZW
                        */

                        
                                    protected Quantum183 localZW ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZW(){
                               return localZW;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZW
                               */
                               public void setZW(Quantum183 param){
                            
                                            this.localZW=param;
                                    

                               }
                            

                        /**
                        * field for ZZN
                        */

                        
                                    protected Quantum183 localZZN ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZZN(){
                               return localZZN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZZN
                               */
                               public void setZZN(Quantum183 param){
                            
                                            this.localZZN=param;
                                    

                               }
                            

                        /**
                        * field for ZTI
                        */

                        
                                    protected Quantum183 localZTI ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZTI(){
                               return localZTI;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZTI
                               */
                               public void setZTI(Quantum183 param){
                            
                                            this.localZTI=param;
                                    

                               }
                            

                        /**
                        * field for ZZR
                        */

                        
                                    protected Quantum183 localZZR ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZZR(){
                               return localZZR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZZR
                               */
                               public void setZZR(Quantum183 param){
                            
                                            this.localZZR=param;
                                    

                               }
                            

                        /**
                        * field for ZN
                        */

                        
                                    protected Quantum184 localZN ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum184
                           */
                           public  Quantum184 getZN(){
                               return localZN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZN
                               */
                               public void setZN(Quantum184 param){
                            
                                            this.localZN=param;
                                    

                               }
                            

                        /**
                        * field for ZTA1
                        */

                        
                                    protected Quantum183 localZTA1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZTA1(){
                               return localZTA1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZTA1
                               */
                               public void setZTA1(Quantum183 param){
                            
                                            this.localZTA1=param;
                                    

                               }
                            

                        /**
                        * field for ZTS
                        */

                        
                                    protected Quantum180 localZTS ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getZTS(){
                               return localZTS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZTS
                               */
                               public void setZTS(Quantum180 param){
                            
                                            this.localZTS=param;
                                    

                               }
                            

                        /**
                        * field for ZYS
                        */

                        
                                    protected Quantum180 localZYS ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getZYS(){
                               return localZYS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZYS
                               */
                               public void setZYS(Quantum180 param){
                            
                                            this.localZYS=param;
                                    

                               }
                            

                        /**
                        * field for ZE
                        */

                        
                                    protected Quantum180 localZE ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getZE(){
                               return localZE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZE
                               */
                               public void setZE(Quantum180 param){
                            
                                            this.localZE=param;
                                    

                               }
                            

                        /**
                        * field for ZR
                        */

                        
                                    protected Quantum180 localZR ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getZR(){
                               return localZR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZR
                               */
                               public void setZR(Quantum180 param){
                            
                                            this.localZR=param;
                                    

                               }
                            

                        /**
                        * field for ZHB
                        */

                        
                                    protected Quantum180 localZHB ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getZHB(){
                               return localZHB;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZHB
                               */
                               public void setZHB(Quantum180 param){
                            
                                            this.localZHB=param;
                                    

                               }
                            

                        /**
                        * field for ZJ
                        */

                        
                                    protected Quantum180 localZJ ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getZJ(){
                               return localZJ;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZJ
                               */
                               public void setZJ(Quantum180 param){
                            
                                            this.localZJ=param;
                                    

                               }
                            

                        /**
                        * field for ZJ1
                        */

                        
                                    protected Quantum180 localZJ1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getZJ1(){
                               return localZJ1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZJ1
                               */
                               public void setZJ1(Quantum180 param){
                            
                                            this.localZJ1=param;
                                    

                               }
                            

                        /**
                        * field for ZJ2
                        */

                        
                                    protected Quantum180 localZJ2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getZJ2(){
                               return localZJ2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZJ2
                               */
                               public void setZJ2(Quantum180 param){
                            
                                            this.localZJ2=param;
                                    

                               }
                            

                        /**
                        * field for ZFE
                        */

                        
                                    protected Quantum183 localZFE ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZFE(){
                               return localZFE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZFE
                               */
                               public void setZFE(Quantum183 param){
                            
                                            this.localZFE=param;
                                    

                               }
                            

                        /**
                        * field for ZB
                        */

                        
                                    protected Quantum184 localZB ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum184
                           */
                           public  Quantum184 getZB(){
                               return localZB;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZB
                               */
                               public void setZB(Quantum184 param){
                            
                                            this.localZB=param;
                                    

                               }
                            

                        /**
                        * field for ZUSER1
                        */

                        
                                    protected Quantum183 localZUSER1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZUSER1(){
                               return localZUSER1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZUSER1
                               */
                               public void setZUSER1(Quantum183 param){
                            
                                            this.localZUSER1=param;
                                    

                               }
                            

                        /**
                        * field for ZUSER2
                        */

                        
                                    protected Quantum183 localZUSER2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZUSER2(){
                               return localZUSER2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZUSER2
                               */
                               public void setZUSER2(Quantum183 param){
                            
                                            this.localZUSER2=param;
                                    

                               }
                            

                        /**
                        * field for ZUSER3
                        */

                        
                                    protected Quantum183 localZUSER3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZUSER3(){
                               return localZUSER3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZUSER3
                               */
                               public void setZUSER3(Quantum183 param){
                            
                                            this.localZUSER3=param;
                                    

                               }
                            

                        /**
                        * field for ZCD
                        */

                        
                                    protected Quantum183 localZCD ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZCD(){
                               return localZCD;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZCD
                               */
                               public void setZCD(Quantum183 param){
                            
                                            this.localZCD=param;
                                    

                               }
                            

                        /**
                        * field for LIFNR
                        */

                        
                                    protected Char10 localLIFNR ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char10
                           */
                           public  Char10 getLIFNR(){
                               return localLIFNR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LIFNR
                               */
                               public void setLIFNR(Char10 param){
                            
                                            this.localLIFNR=param;
                                    

                               }
                            

                        /**
                        * field for MEMO
                        */

                        
                                    protected Char100 localMEMO ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char100
                           */
                           public  Char100 getMEMO(){
                               return localMEMO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MEMO
                               */
                               public void setMEMO(Char100 param){
                            
                                            this.localMEMO=param;
                                    

                               }
                            

                        /**
                        * field for TEMP1
                        */

                        
                                    protected Char15 localTEMP1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getTEMP1(){
                               return localTEMP1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMP1
                               */
                               public void setTEMP1(Char15 param){
                            
                                            this.localTEMP1=param;
                                    

                               }
                            

                        /**
                        * field for HOLD1
                        */

                        
                                    protected Char20 localHOLD1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHOLD1(){
                               return localHOLD1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HOLD1
                               */
                               public void setHOLD1(Char20 param){
                            
                                            this.localHOLD1=param;
                                    

                               }
                            

                        /**
                        * field for TEMP2
                        */

                        
                                    protected Char15 localTEMP2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getTEMP2(){
                               return localTEMP2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMP2
                               */
                               public void setTEMP2(Char15 param){
                            
                                            this.localTEMP2=param;
                                    

                               }
                            

                        /**
                        * field for HOLD2
                        */

                        
                                    protected Char20 localHOLD2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHOLD2(){
                               return localHOLD2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HOLD2
                               */
                               public void setHOLD2(Char20 param){
                            
                                            this.localHOLD2=param;
                                    

                               }
                            

                        /**
                        * field for TEMP3
                        */

                        
                                    protected Char15 localTEMP3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getTEMP3(){
                               return localTEMP3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMP3
                               */
                               public void setTEMP3(Char15 param){
                            
                                            this.localTEMP3=param;
                                    

                               }
                            

                        /**
                        * field for HOLD3
                        */

                        
                                    protected Char20 localHOLD3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHOLD3(){
                               return localHOLD3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HOLD3
                               */
                               public void setHOLD3(Char20 param){
                            
                                            this.localHOLD3=param;
                                    

                               }
                            

                        /**
                        * field for TEMP4
                        */

                        
                                    protected Char15 localTEMP4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getTEMP4(){
                               return localTEMP4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMP4
                               */
                               public void setTEMP4(Char15 param){
                            
                                            this.localTEMP4=param;
                                    

                               }
                            

                        /**
                        * field for HOLD4
                        */

                        
                                    protected Char20 localHOLD4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getHOLD4(){
                               return localHOLD4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HOLD4
                               */
                               public void setHOLD4(Char20 param){
                            
                                            this.localHOLD4=param;
                                    

                               }
                            

                        /**
                        * field for VT
                        */

                        
                                    protected Char1 localVT ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getVT(){
                               return localVT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VT
                               */
                               public void setVT(Char1 param){
                            
                                            this.localVT=param;
                                    

                               }
                            

                        /**
                        * field for PT
                        */

                        
                                    protected Char1 localPT ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getPT(){
                               return localPT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PT
                               */
                               public void setPT(Char1 param){
                            
                                            this.localPT=param;
                                    

                               }
                            

                        /**
                        * field for MT
                        */

                        
                                    protected Char1 localMT ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getMT(){
                               return localMT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MT
                               */
                               public void setMT(Char1 param){
                            
                                            this.localMT=param;
                                    

                               }
                            

                        /**
                        * field for RT
                        */

                        
                                    protected Char1 localRT ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getRT(){
                               return localRT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RT
                               */
                               public void setRT(Char1 param){
                            
                                            this.localRT=param;
                                    

                               }
                            

                        /**
                        * field for UT
                        */

                        
                                    protected Char1 localUT ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getUT(){
                               return localUT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UT
                               */
                               public void setUT(Char1 param){
                            
                                            this.localUT=param;
                                    

                               }
                            

                        /**
                        * field for MCLASS
                        */

                        
                                    protected Quantum180 localMCLASS ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getMCLASS(){
                               return localMCLASS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MCLASS
                               */
                               public void setMCLASS(Quantum180 param){
                            
                                            this.localMCLASS=param;
                                    

                               }
                            

                        /**
                        * field for TEMPER1
                        */

                        
                                    protected Quantum180 localTEMPER1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getTEMPER1(){
                               return localTEMPER1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMPER1
                               */
                               public void setTEMPER1(Quantum180 param){
                            
                                            this.localTEMPER1=param;
                                    

                               }
                            

                        /**
                        * field for TIME1
                        */

                        
                                    protected Quantum181 localTIME1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum181
                           */
                           public  Quantum181 getTIME1(){
                               return localTIME1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TIME1
                               */
                               public void setTIME1(Quantum181 param){
                            
                                            this.localTIME1=param;
                                    

                               }
                            

                        /**
                        * field for TEMPER2
                        */

                        
                                    protected Quantum180 localTEMPER2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getTEMPER2(){
                               return localTEMPER2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMPER2
                               */
                               public void setTEMPER2(Quantum180 param){
                            
                                            this.localTEMPER2=param;
                                    

                               }
                            

                        /**
                        * field for PRE
                        */

                        
                                    protected Quantum180 localPRE ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getPRE(){
                               return localPRE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PRE
                               */
                               public void setPRE(Quantum180 param){
                            
                                            this.localPRE=param;
                                    

                               }
                            

                        /**
                        * field for TIME2
                        */

                        
                                    protected Quantum181 localTIME2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum181
                           */
                           public  Quantum181 getTIME2(){
                               return localTIME2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TIME2
                               */
                               public void setTIME2(Quantum181 param){
                            
                                            this.localTIME2=param;
                                    

                               }
                            

                        /**
                        * field for POST
                        */

                        
                                    protected Quantum180 localPOST ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getPOST(){
                               return localPOST;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param POST
                               */
                               public void setPOST(Quantum180 param){
                            
                                            this.localPOST=param;
                                    

                               }
                            

                        /**
                        * field for TEMPER3
                        */

                        
                                    protected Quantum180 localTEMPER3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getTEMPER3(){
                               return localTEMPER3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMPER3
                               */
                               public void setTEMPER3(Quantum180 param){
                            
                                            this.localTEMPER3=param;
                                    

                               }
                            

                        /**
                        * field for TIME3
                        */

                        
                                    protected Quantum181 localTIME3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum181
                           */
                           public  Quantum181 getTIME3(){
                               return localTIME3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TIME3
                               */
                               public void setTIME3(Quantum181 param){
                            
                                            this.localTIME3=param;
                                    

                               }
                            

                        /**
                        * field for TEMPER4
                        */

                        
                                    protected Quantum180 localTEMPER4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getTEMPER4(){
                               return localTEMPER4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMPER4
                               */
                               public void setTEMPER4(Quantum180 param){
                            
                                            this.localTEMPER4=param;
                                    

                               }
                            

                        /**
                        * field for TIME4
                        */

                        
                                    protected Quantum181 localTIME4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum181
                           */
                           public  Quantum181 getTIME4(){
                               return localTIME4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TIME4
                               */
                               public void setTIME4(Quantum181 param){
                            
                                            this.localTIME4=param;
                                    

                               }
                            

                        /**
                        * field for TEMPER5
                        */

                        
                                    protected Quantum180 localTEMPER5 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getTEMPER5(){
                               return localTEMPER5;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMPER5
                               */
                               public void setTEMPER5(Quantum180 param){
                            
                                            this.localTEMPER5=param;
                                    

                               }
                            

                        /**
                        * field for TIME5
                        */

                        
                                    protected Quantum181 localTIME5 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum181
                           */
                           public  Quantum181 getTIME5(){
                               return localTIME5;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TIME5
                               */
                               public void setTIME5(Quantum181 param){
                            
                                            this.localTIME5=param;
                                    

                               }
                            

                        /**
                        * field for TEMPER6
                        */

                        
                                    protected Quantum180 localTEMPER6 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getTEMPER6(){
                               return localTEMPER6;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMPER6
                               */
                               public void setTEMPER6(Quantum180 param){
                            
                                            this.localTEMPER6=param;
                                    

                               }
                            

                        /**
                        * field for TIME6
                        */

                        
                                    protected Quantum181 localTIME6 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum181
                           */
                           public  Quantum181 getTIME6(){
                               return localTIME6;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TIME6
                               */
                               public void setTIME6(Quantum181 param){
                            
                                            this.localTIME6=param;
                                    

                               }
                            

                        /**
                        * field for TEMPER7
                        */

                        
                                    protected Quantum180 localTEMPER7 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum180
                           */
                           public  Quantum180 getTEMPER7(){
                               return localTEMPER7;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEMPER7
                               */
                               public void setTEMPER7(Quantum180 param){
                            
                                            this.localTEMPER7=param;
                                    

                               }
                            

                        /**
                        * field for TIME7
                        */

                        
                                    protected Quantum181 localTIME7 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum181
                           */
                           public  Quantum181 getTIME7(){
                               return localTIME7;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TIME7
                               */
                               public void setTIME7(Quantum181 param){
                            
                                            this.localTIME7=param;
                                    

                               }
                            

                        /**
                        * field for SB
                        */

                        
                                    protected Char18 localSB ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char18
                           */
                           public  Char18 getSB(){
                               return localSB;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SB
                               */
                               public void setSB(Char18 param){
                            
                                            this.localSB=param;
                                    

                               }
                            

                        /**
                        * field for CO
                        */

                        
                                    protected Quantum183 localCO ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getCO(){
                               return localCO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CO
                               */
                               public void setCO(Quantum183 param){
                            
                                            this.localCO=param;
                                    

                               }
                            

                        /**
                        * field for FG
                        */

                        
                                    protected Char1 localFG ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char1
                           */
                           public  Char1 getFG(){
                               return localFG;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FG
                               */
                               public void setFG(Char1 param){
                            
                                            this.localFG=param;
                                    

                               }
                            

                        /**
                        * field for ZYS2
                        */

                        
                                    protected Quantum183 localZYS2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZYS2(){
                               return localZYS2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZYS2
                               */
                               public void setZYS2(Quantum183 param){
                            
                                            this.localZYS2=param;
                                    

                               }
                            

                        /**
                        * field for ZSN
                        */

                        
                                    protected Quantum183 localZSN ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZSN(){
                               return localZSN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZSN
                               */
                               public void setZSN(Quantum183 param){
                            
                                            this.localZSN=param;
                                    

                               }
                            

                        /**
                        * field for ZSB
                        */

                        
                                    protected Quantum183 localZSB ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZSB(){
                               return localZSB;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZSB
                               */
                               public void setZSB(Quantum183 param){
                            
                                            this.localZSB=param;
                                    

                               }
                            

                        /**
                        * field for ZAS
                        */

                        
                                    protected Quantum183 localZAS ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZAS(){
                               return localZAS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZAS
                               */
                               public void setZAS(Quantum183 param){
                            
                                            this.localZAS=param;
                                    

                               }
                            

                        /**
                        * field for ZER
                        */

                        
                                    protected Quantum183 localZER ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZER(){
                               return localZER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZER
                               */
                               public void setZER(Quantum183 param){
                            
                                            this.localZER=param;
                                    

                               }
                            

                        /**
                        * field for ZFF
                        */

                        
                                    protected Char18 localZFF ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char18
                           */
                           public  Char18 getZFF(){
                               return localZFF;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZFF
                               */
                               public void setZFF(Char18 param){
                            
                                            this.localZFF=param;
                                    

                               }
                            

                        /**
                        * field for ZQTR
                        */

                        
                                    protected Char18 localZQTR ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char18
                           */
                           public  Char18 getZQTR(){
                               return localZQTR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZQTR
                               */
                               public void setZQTR(Char18 param){
                            
                                            this.localZQTR=param;
                                    

                               }
                            

                        /**
                        * field for CJ
                        */

                        
                                    protected Char15 localCJ ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getCJ(){
                               return localCJ;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CJ
                               */
                               public void setCJ(Char15 param){
                            
                                            this.localCJ=param;
                                    

                               }
                            

                        /**
                        * field for CJ_AVG
                        */

                        
                                    protected Char15 localCJ_AVG ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getCJ_AVG(){
                               return localCJ_AVG;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CJ_AVG
                               */
                               public void setCJ_AVG(Char15 param){
                            
                                            this.localCJ_AVG=param;
                                    

                               }
                            

                        /**
                        * field for CJ_MIN
                        */

                        
                                    protected Char15 localCJ_MIN ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char15
                           */
                           public  Char15 getCJ_MIN(){
                               return localCJ_MIN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CJ_MIN
                               */
                               public void setCJ_MIN(Char15 param){
                            
                                            this.localCJ_MIN=param;
                                    

                               }
                            

                        /**
                        * field for MARKING
                        */

                        
                                    protected Char200 localMARKING ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char200
                           */
                           public  Char200 getMARKING(){
                               return localMARKING;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MARKING
                               */
                               public void setMARKING(Char200 param){
                            
                                            this.localMARKING=param;
                                    

                               }
                            

                        /**
                        * field for P_RNAF
                        */

                        
                                    protected Char200 localP_RNAF ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char200
                           */
                           public  Char200 getP_RNAF(){
                               return localP_RNAF;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param P_RNAF
                               */
                               public void setP_RNAF(Char200 param){
                            
                                            this.localP_RNAF=param;
                                    

                               }
                            

                        /**
                        * field for PREN
                        */

                        
                                    protected Quantum183 localPREN ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getPREN(){
                               return localPREN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PREN
                               */
                               public void setPREN(Quantum183 param){
                            
                                            this.localPREN=param;
                                    

                               }
                            

                        /**
                        * field for BATCH_NO
                        */

                        
                                    protected Char10 localBATCH_NO ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char10
                           */
                           public  Char10 getBATCH_NO(){
                               return localBATCH_NO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BATCH_NO
                               */
                               public void setBATCH_NO(Char10 param){
                            
                                            this.localBATCH_NO=param;
                                    

                               }
                            

                        /**
                        * field for FURN1
                        */

                        
                                    protected Char20 localFURN1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getFURN1(){
                               return localFURN1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FURN1
                               */
                               public void setFURN1(Char20 param){
                            
                                            this.localFURN1=param;
                                    

                               }
                            

                        /**
                        * field for FURN2
                        */

                        
                                    protected Char20 localFURN2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getFURN2(){
                               return localFURN2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FURN2
                               */
                               public void setFURN2(Char20 param){
                            
                                            this.localFURN2=param;
                                    

                               }
                            

                        /**
                        * field for FURN3
                        */

                        
                                    protected Char20 localFURN3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getFURN3(){
                               return localFURN3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FURN3
                               */
                               public void setFURN3(Char20 param){
                            
                                            this.localFURN3=param;
                                    

                               }
                            

                        /**
                        * field for CUSTO
                        */

                        
                                    protected Char40 localCUSTO ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char40
                           */
                           public  Char40 getCUSTO(){
                               return localCUSTO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CUSTO
                               */
                               public void setCUSTO(Char40 param){
                            
                                            this.localCUSTO=param;
                                    

                               }
                            

                        /**
                        * field for ZAI
                        */

                        
                                    protected Quantum183 localZAI ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZAI(){
                               return localZAI;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZAI
                               */
                               public void setZAI(Quantum183 param){
                            
                                            this.localZAI=param;
                                    

                               }
                            

                        /**
                        * field for ZTCRE
                        */

                        
                                    protected Quantum183 localZTCRE ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZTCRE(){
                               return localZTCRE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZTCRE
                               */
                               public void setZTCRE(Quantum183 param){
                            
                                            this.localZTCRE=param;
                                    

                               }
                            

                        /**
                        * field for MEMO1
                        */

                        
                                    protected Char100 localMEMO1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char100
                           */
                           public  Char100 getMEMO1(){
                               return localMEMO1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MEMO1
                               */
                               public void setMEMO1(Char100 param){
                            
                                            this.localMEMO1=param;
                                    

                               }
                            

                        /**
                        * field for TEXTURE
                        */

                        
                                    protected Char40 localTEXTURE ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char40
                           */
                           public  Char40 getTEXTURE(){
                               return localTEXTURE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TEXTURE
                               */
                               public void setTEXTURE(Char40 param){
                            
                                            this.localTEXTURE=param;
                                    

                               }
                            

                        /**
                        * field for ZH
                        */

                        
                                    protected Quantum183 localZH ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZH(){
                               return localZH;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZH
                               */
                               public void setZH(Quantum183 param){
                            
                                            this.localZH=param;
                                    

                               }
                            

                        /**
                        * field for ZO
                        */

                        
                                    protected Quantum183 localZO ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZO(){
                               return localZO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZO
                               */
                               public void setZO(Quantum183 param){
                            
                                            this.localZO=param;
                                    

                               }
                            

                        /**
                        * field for ZZFE
                        */

                        
                                    protected Quantum183 localZZFE ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZZFE(){
                               return localZZFE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZZFE
                               */
                               public void setZZFE(Quantum183 param){
                            
                                            this.localZZFE=param;
                                    

                               }
                            

                        /**
                        * field for ZTA
                        */

                        
                                    protected Quantum183 localZTA ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZTA(){
                               return localZTA;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZTA
                               */
                               public void setZTA(Quantum183 param){
                            
                                            this.localZTA=param;
                                    

                               }
                            

                        /**
                        * field for ZCA
                        */

                        
                                    protected Quantum183 localZCA ;
                                

                           /**
                           * Auto generated getter method
                           * @return Quantum183
                           */
                           public  Quantum183 getZCA(){
                               return localZCA;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZCA
                               */
                               public void setZCA(Quantum183 param){
                            
                                            this.localZCA=param;
                                    

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
                       ZLUHAO.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ZLUHAO",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZLUHAO",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localMANDT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MANDT cannot be null!!");
                                            }
                                           localMANDT.serialize(new javax.xml.namespace.QName("","MANDT"),
                                               factory,xmlWriter);
                                        
                                            if (localZCZ==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZCZ cannot be null!!");
                                            }
                                           localZCZ.serialize(new javax.xml.namespace.QName("","ZCZ"),
                                               factory,xmlWriter);
                                        
                                            if (localLUHAO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("LUHAO cannot be null!!");
                                            }
                                           localLUHAO.serialize(new javax.xml.namespace.QName("","LUHAO"),
                                               factory,xmlWriter);
                                        
                                            if (localSTOCH==null){
                                                 throw new org.apache.axis2.databinding.ADBException("STOCH cannot be null!!");
                                            }
                                           localSTOCH.serialize(new javax.xml.namespace.QName("","STOCH"),
                                               factory,xmlWriter);
                                        
                                            if (localZDEL==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZDEL cannot be null!!");
                                            }
                                           localZDEL.serialize(new javax.xml.namespace.QName("","ZDEL"),
                                               factory,xmlWriter);
                                        
                                            if (localCUSER==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CUSER cannot be null!!");
                                            }
                                           localCUSER.serialize(new javax.xml.namespace.QName("","CUSER"),
                                               factory,xmlWriter);
                                        
                                            if (localCDATE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CDATE cannot be null!!");
                                            }
                                           localCDATE.serialize(new javax.xml.namespace.QName("","CDATE"),
                                               factory,xmlWriter);
                                        
                                            if (localCTIME==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CTIME cannot be null!!");
                                            }
                                           localCTIME.serialize(new javax.xml.namespace.QName("","CTIME"),
                                               factory,xmlWriter);
                                        
                                            if (localMUSER==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MUSER cannot be null!!");
                                            }
                                           localMUSER.serialize(new javax.xml.namespace.QName("","MUSER"),
                                               factory,xmlWriter);
                                        
                                            if (localMDATE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MDATE cannot be null!!");
                                            }
                                           localMDATE.serialize(new javax.xml.namespace.QName("","MDATE"),
                                               factory,xmlWriter);
                                        
                                            if (localMTIME==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MTIME cannot be null!!");
                                            }
                                           localMTIME.serialize(new javax.xml.namespace.QName("","MTIME"),
                                               factory,xmlWriter);
                                        
                                            if (localZC==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZC cannot be null!!");
                                            }
                                           localZC.serialize(new javax.xml.namespace.QName("","ZC"),
                                               factory,xmlWriter);
                                        
                                            if (localZSI==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZSI cannot be null!!");
                                            }
                                           localZSI.serialize(new javax.xml.namespace.QName("","ZSI"),
                                               factory,xmlWriter);
                                        
                                            if (localZMN==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZMN cannot be null!!");
                                            }
                                           localZMN.serialize(new javax.xml.namespace.QName("","ZMN"),
                                               factory,xmlWriter);
                                        
                                            if (localZP==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZP cannot be null!!");
                                            }
                                           localZP.serialize(new javax.xml.namespace.QName("","ZP"),
                                               factory,xmlWriter);
                                        
                                            if (localZS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZS cannot be null!!");
                                            }
                                           localZS.serialize(new javax.xml.namespace.QName("","ZS"),
                                               factory,xmlWriter);
                                        
                                            if (localZCR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZCR cannot be null!!");
                                            }
                                           localZCR.serialize(new javax.xml.namespace.QName("","ZCR"),
                                               factory,xmlWriter);
                                        
                                            if (localZNI==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZNI cannot be null!!");
                                            }
                                           localZNI.serialize(new javax.xml.namespace.QName("","ZNI"),
                                               factory,xmlWriter);
                                        
                                            if (localZMO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZMO cannot be null!!");
                                            }
                                           localZMO.serialize(new javax.xml.namespace.QName("","ZMO"),
                                               factory,xmlWriter);
                                        
                                            if (localZCU==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZCU cannot be null!!");
                                            }
                                           localZCU.serialize(new javax.xml.namespace.QName("","ZCU"),
                                               factory,xmlWriter);
                                        
                                            if (localZV==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZV cannot be null!!");
                                            }
                                           localZV.serialize(new javax.xml.namespace.QName("","ZV"),
                                               factory,xmlWriter);
                                        
                                            if (localZAL==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZAL cannot be null!!");
                                            }
                                           localZAL.serialize(new javax.xml.namespace.QName("","ZAL"),
                                               factory,xmlWriter);
                                        
                                            if (localZNB==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZNB cannot be null!!");
                                            }
                                           localZNB.serialize(new javax.xml.namespace.QName("","ZNB"),
                                               factory,xmlWriter);
                                        
                                            if (localZW==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZW cannot be null!!");
                                            }
                                           localZW.serialize(new javax.xml.namespace.QName("","ZW"),
                                               factory,xmlWriter);
                                        
                                            if (localZZN==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZZN cannot be null!!");
                                            }
                                           localZZN.serialize(new javax.xml.namespace.QName("","ZZN"),
                                               factory,xmlWriter);
                                        
                                            if (localZTI==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZTI cannot be null!!");
                                            }
                                           localZTI.serialize(new javax.xml.namespace.QName("","ZTI"),
                                               factory,xmlWriter);
                                        
                                            if (localZZR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZZR cannot be null!!");
                                            }
                                           localZZR.serialize(new javax.xml.namespace.QName("","ZZR"),
                                               factory,xmlWriter);
                                        
                                            if (localZN==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZN cannot be null!!");
                                            }
                                           localZN.serialize(new javax.xml.namespace.QName("","ZN"),
                                               factory,xmlWriter);
                                        
                                            if (localZTA1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZTA1 cannot be null!!");
                                            }
                                           localZTA1.serialize(new javax.xml.namespace.QName("","ZTA1"),
                                               factory,xmlWriter);
                                        
                                            if (localZTS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZTS cannot be null!!");
                                            }
                                           localZTS.serialize(new javax.xml.namespace.QName("","ZTS"),
                                               factory,xmlWriter);
                                        
                                            if (localZYS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZYS cannot be null!!");
                                            }
                                           localZYS.serialize(new javax.xml.namespace.QName("","ZYS"),
                                               factory,xmlWriter);
                                        
                                            if (localZE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZE cannot be null!!");
                                            }
                                           localZE.serialize(new javax.xml.namespace.QName("","ZE"),
                                               factory,xmlWriter);
                                        
                                            if (localZR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZR cannot be null!!");
                                            }
                                           localZR.serialize(new javax.xml.namespace.QName("","ZR"),
                                               factory,xmlWriter);
                                        
                                            if (localZHB==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZHB cannot be null!!");
                                            }
                                           localZHB.serialize(new javax.xml.namespace.QName("","ZHB"),
                                               factory,xmlWriter);
                                        
                                            if (localZJ==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZJ cannot be null!!");
                                            }
                                           localZJ.serialize(new javax.xml.namespace.QName("","ZJ"),
                                               factory,xmlWriter);
                                        
                                            if (localZJ1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZJ1 cannot be null!!");
                                            }
                                           localZJ1.serialize(new javax.xml.namespace.QName("","ZJ1"),
                                               factory,xmlWriter);
                                        
                                            if (localZJ2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZJ2 cannot be null!!");
                                            }
                                           localZJ2.serialize(new javax.xml.namespace.QName("","ZJ2"),
                                               factory,xmlWriter);
                                        
                                            if (localZFE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZFE cannot be null!!");
                                            }
                                           localZFE.serialize(new javax.xml.namespace.QName("","ZFE"),
                                               factory,xmlWriter);
                                        
                                            if (localZB==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZB cannot be null!!");
                                            }
                                           localZB.serialize(new javax.xml.namespace.QName("","ZB"),
                                               factory,xmlWriter);
                                        
                                            if (localZUSER1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZUSER1 cannot be null!!");
                                            }
                                           localZUSER1.serialize(new javax.xml.namespace.QName("","ZUSER1"),
                                               factory,xmlWriter);
                                        
                                            if (localZUSER2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZUSER2 cannot be null!!");
                                            }
                                           localZUSER2.serialize(new javax.xml.namespace.QName("","ZUSER2"),
                                               factory,xmlWriter);
                                        
                                            if (localZUSER3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZUSER3 cannot be null!!");
                                            }
                                           localZUSER3.serialize(new javax.xml.namespace.QName("","ZUSER3"),
                                               factory,xmlWriter);
                                        
                                            if (localZCD==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZCD cannot be null!!");
                                            }
                                           localZCD.serialize(new javax.xml.namespace.QName("","ZCD"),
                                               factory,xmlWriter);
                                        
                                            if (localLIFNR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("LIFNR cannot be null!!");
                                            }
                                           localLIFNR.serialize(new javax.xml.namespace.QName("","LIFNR"),
                                               factory,xmlWriter);
                                        
                                            if (localMEMO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MEMO cannot be null!!");
                                            }
                                           localMEMO.serialize(new javax.xml.namespace.QName("","MEMO"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMP1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMP1 cannot be null!!");
                                            }
                                           localTEMP1.serialize(new javax.xml.namespace.QName("","TEMP1"),
                                               factory,xmlWriter);
                                        
                                            if (localHOLD1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HOLD1 cannot be null!!");
                                            }
                                           localHOLD1.serialize(new javax.xml.namespace.QName("","HOLD1"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMP2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMP2 cannot be null!!");
                                            }
                                           localTEMP2.serialize(new javax.xml.namespace.QName("","TEMP2"),
                                               factory,xmlWriter);
                                        
                                            if (localHOLD2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HOLD2 cannot be null!!");
                                            }
                                           localHOLD2.serialize(new javax.xml.namespace.QName("","HOLD2"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMP3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMP3 cannot be null!!");
                                            }
                                           localTEMP3.serialize(new javax.xml.namespace.QName("","TEMP3"),
                                               factory,xmlWriter);
                                        
                                            if (localHOLD3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HOLD3 cannot be null!!");
                                            }
                                           localHOLD3.serialize(new javax.xml.namespace.QName("","HOLD3"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMP4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMP4 cannot be null!!");
                                            }
                                           localTEMP4.serialize(new javax.xml.namespace.QName("","TEMP4"),
                                               factory,xmlWriter);
                                        
                                            if (localHOLD4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HOLD4 cannot be null!!");
                                            }
                                           localHOLD4.serialize(new javax.xml.namespace.QName("","HOLD4"),
                                               factory,xmlWriter);
                                        
                                            if (localVT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("VT cannot be null!!");
                                            }
                                           localVT.serialize(new javax.xml.namespace.QName("","VT"),
                                               factory,xmlWriter);
                                        
                                            if (localPT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PT cannot be null!!");
                                            }
                                           localPT.serialize(new javax.xml.namespace.QName("","PT"),
                                               factory,xmlWriter);
                                        
                                            if (localMT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MT cannot be null!!");
                                            }
                                           localMT.serialize(new javax.xml.namespace.QName("","MT"),
                                               factory,xmlWriter);
                                        
                                            if (localRT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("RT cannot be null!!");
                                            }
                                           localRT.serialize(new javax.xml.namespace.QName("","RT"),
                                               factory,xmlWriter);
                                        
                                            if (localUT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("UT cannot be null!!");
                                            }
                                           localUT.serialize(new javax.xml.namespace.QName("","UT"),
                                               factory,xmlWriter);
                                        
                                            if (localMCLASS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MCLASS cannot be null!!");
                                            }
                                           localMCLASS.serialize(new javax.xml.namespace.QName("","MCLASS"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMPER1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMPER1 cannot be null!!");
                                            }
                                           localTEMPER1.serialize(new javax.xml.namespace.QName("","TEMPER1"),
                                               factory,xmlWriter);
                                        
                                            if (localTIME1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TIME1 cannot be null!!");
                                            }
                                           localTIME1.serialize(new javax.xml.namespace.QName("","TIME1"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMPER2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMPER2 cannot be null!!");
                                            }
                                           localTEMPER2.serialize(new javax.xml.namespace.QName("","TEMPER2"),
                                               factory,xmlWriter);
                                        
                                            if (localPRE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PRE cannot be null!!");
                                            }
                                           localPRE.serialize(new javax.xml.namespace.QName("","PRE"),
                                               factory,xmlWriter);
                                        
                                            if (localTIME2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TIME2 cannot be null!!");
                                            }
                                           localTIME2.serialize(new javax.xml.namespace.QName("","TIME2"),
                                               factory,xmlWriter);
                                        
                                            if (localPOST==null){
                                                 throw new org.apache.axis2.databinding.ADBException("POST cannot be null!!");
                                            }
                                           localPOST.serialize(new javax.xml.namespace.QName("","POST"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMPER3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMPER3 cannot be null!!");
                                            }
                                           localTEMPER3.serialize(new javax.xml.namespace.QName("","TEMPER3"),
                                               factory,xmlWriter);
                                        
                                            if (localTIME3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TIME3 cannot be null!!");
                                            }
                                           localTIME3.serialize(new javax.xml.namespace.QName("","TIME3"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMPER4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMPER4 cannot be null!!");
                                            }
                                           localTEMPER4.serialize(new javax.xml.namespace.QName("","TEMPER4"),
                                               factory,xmlWriter);
                                        
                                            if (localTIME4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TIME4 cannot be null!!");
                                            }
                                           localTIME4.serialize(new javax.xml.namespace.QName("","TIME4"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMPER5==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMPER5 cannot be null!!");
                                            }
                                           localTEMPER5.serialize(new javax.xml.namespace.QName("","TEMPER5"),
                                               factory,xmlWriter);
                                        
                                            if (localTIME5==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TIME5 cannot be null!!");
                                            }
                                           localTIME5.serialize(new javax.xml.namespace.QName("","TIME5"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMPER6==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMPER6 cannot be null!!");
                                            }
                                           localTEMPER6.serialize(new javax.xml.namespace.QName("","TEMPER6"),
                                               factory,xmlWriter);
                                        
                                            if (localTIME6==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TIME6 cannot be null!!");
                                            }
                                           localTIME6.serialize(new javax.xml.namespace.QName("","TIME6"),
                                               factory,xmlWriter);
                                        
                                            if (localTEMPER7==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEMPER7 cannot be null!!");
                                            }
                                           localTEMPER7.serialize(new javax.xml.namespace.QName("","TEMPER7"),
                                               factory,xmlWriter);
                                        
                                            if (localTIME7==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TIME7 cannot be null!!");
                                            }
                                           localTIME7.serialize(new javax.xml.namespace.QName("","TIME7"),
                                               factory,xmlWriter);
                                        
                                            if (localSB==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SB cannot be null!!");
                                            }
                                           localSB.serialize(new javax.xml.namespace.QName("","SB"),
                                               factory,xmlWriter);
                                        
                                            if (localCO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CO cannot be null!!");
                                            }
                                           localCO.serialize(new javax.xml.namespace.QName("","CO"),
                                               factory,xmlWriter);
                                        
                                            if (localFG==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FG cannot be null!!");
                                            }
                                           localFG.serialize(new javax.xml.namespace.QName("","FG"),
                                               factory,xmlWriter);
                                        
                                            if (localZYS2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZYS2 cannot be null!!");
                                            }
                                           localZYS2.serialize(new javax.xml.namespace.QName("","ZYS2"),
                                               factory,xmlWriter);
                                        
                                            if (localZSN==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZSN cannot be null!!");
                                            }
                                           localZSN.serialize(new javax.xml.namespace.QName("","ZSN"),
                                               factory,xmlWriter);
                                        
                                            if (localZSB==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZSB cannot be null!!");
                                            }
                                           localZSB.serialize(new javax.xml.namespace.QName("","ZSB"),
                                               factory,xmlWriter);
                                        
                                            if (localZAS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZAS cannot be null!!");
                                            }
                                           localZAS.serialize(new javax.xml.namespace.QName("","ZAS"),
                                               factory,xmlWriter);
                                        
                                            if (localZER==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZER cannot be null!!");
                                            }
                                           localZER.serialize(new javax.xml.namespace.QName("","ZER"),
                                               factory,xmlWriter);
                                        
                                            if (localZFF==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZFF cannot be null!!");
                                            }
                                           localZFF.serialize(new javax.xml.namespace.QName("","ZFF"),
                                               factory,xmlWriter);
                                        
                                            if (localZQTR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZQTR cannot be null!!");
                                            }
                                           localZQTR.serialize(new javax.xml.namespace.QName("","ZQTR"),
                                               factory,xmlWriter);
                                        
                                            if (localCJ==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CJ cannot be null!!");
                                            }
                                           localCJ.serialize(new javax.xml.namespace.QName("","CJ"),
                                               factory,xmlWriter);
                                        
                                            if (localCJ_AVG==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CJ_AVG cannot be null!!");
                                            }
                                           localCJ_AVG.serialize(new javax.xml.namespace.QName("","CJ_AVG"),
                                               factory,xmlWriter);
                                        
                                            if (localCJ_MIN==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CJ_MIN cannot be null!!");
                                            }
                                           localCJ_MIN.serialize(new javax.xml.namespace.QName("","CJ_MIN"),
                                               factory,xmlWriter);
                                        
                                            if (localMARKING==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MARKING cannot be null!!");
                                            }
                                           localMARKING.serialize(new javax.xml.namespace.QName("","MARKING"),
                                               factory,xmlWriter);
                                        
                                            if (localP_RNAF==null){
                                                 throw new org.apache.axis2.databinding.ADBException("P_RNAF cannot be null!!");
                                            }
                                           localP_RNAF.serialize(new javax.xml.namespace.QName("","P_RNAF"),
                                               factory,xmlWriter);
                                        
                                            if (localPREN==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PREN cannot be null!!");
                                            }
                                           localPREN.serialize(new javax.xml.namespace.QName("","PREN"),
                                               factory,xmlWriter);
                                        
                                            if (localBATCH_NO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BATCH_NO cannot be null!!");
                                            }
                                           localBATCH_NO.serialize(new javax.xml.namespace.QName("","BATCH_NO"),
                                               factory,xmlWriter);
                                        
                                            if (localFURN1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FURN1 cannot be null!!");
                                            }
                                           localFURN1.serialize(new javax.xml.namespace.QName("","FURN1"),
                                               factory,xmlWriter);
                                        
                                            if (localFURN2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FURN2 cannot be null!!");
                                            }
                                           localFURN2.serialize(new javax.xml.namespace.QName("","FURN2"),
                                               factory,xmlWriter);
                                        
                                            if (localFURN3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FURN3 cannot be null!!");
                                            }
                                           localFURN3.serialize(new javax.xml.namespace.QName("","FURN3"),
                                               factory,xmlWriter);
                                        
                                            if (localCUSTO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CUSTO cannot be null!!");
                                            }
                                           localCUSTO.serialize(new javax.xml.namespace.QName("","CUSTO"),
                                               factory,xmlWriter);
                                        
                                            if (localZAI==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZAI cannot be null!!");
                                            }
                                           localZAI.serialize(new javax.xml.namespace.QName("","ZAI"),
                                               factory,xmlWriter);
                                        
                                            if (localZTCRE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZTCRE cannot be null!!");
                                            }
                                           localZTCRE.serialize(new javax.xml.namespace.QName("","ZTCRE"),
                                               factory,xmlWriter);
                                        
                                            if (localMEMO1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MEMO1 cannot be null!!");
                                            }
                                           localMEMO1.serialize(new javax.xml.namespace.QName("","MEMO1"),
                                               factory,xmlWriter);
                                        
                                            if (localTEXTURE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TEXTURE cannot be null!!");
                                            }
                                           localTEXTURE.serialize(new javax.xml.namespace.QName("","TEXTURE"),
                                               factory,xmlWriter);
                                        
                                            if (localZH==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZH cannot be null!!");
                                            }
                                           localZH.serialize(new javax.xml.namespace.QName("","ZH"),
                                               factory,xmlWriter);
                                        
                                            if (localZO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZO cannot be null!!");
                                            }
                                           localZO.serialize(new javax.xml.namespace.QName("","ZO"),
                                               factory,xmlWriter);
                                        
                                            if (localZZFE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZZFE cannot be null!!");
                                            }
                                           localZZFE.serialize(new javax.xml.namespace.QName("","ZZFE"),
                                               factory,xmlWriter);
                                        
                                            if (localZTA==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZTA cannot be null!!");
                                            }
                                           localZTA.serialize(new javax.xml.namespace.QName("","ZTA"),
                                               factory,xmlWriter);
                                        
                                            if (localZCA==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZCA cannot be null!!");
                                            }
                                           localZCA.serialize(new javax.xml.namespace.QName("","ZCA"),
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
                                                                      "MANDT"));
                            
                            
                                    if (localMANDT==null){
                                         throw new org.apache.axis2.databinding.ADBException("MANDT cannot be null!!");
                                    }
                                    elementList.add(localMANDT);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZCZ"));
                            
                            
                                    if (localZCZ==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZCZ cannot be null!!");
                                    }
                                    elementList.add(localZCZ);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "LUHAO"));
                            
                            
                                    if (localLUHAO==null){
                                         throw new org.apache.axis2.databinding.ADBException("LUHAO cannot be null!!");
                                    }
                                    elementList.add(localLUHAO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "STOCH"));
                            
                            
                                    if (localSTOCH==null){
                                         throw new org.apache.axis2.databinding.ADBException("STOCH cannot be null!!");
                                    }
                                    elementList.add(localSTOCH);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZDEL"));
                            
                            
                                    if (localZDEL==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZDEL cannot be null!!");
                                    }
                                    elementList.add(localZDEL);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CUSER"));
                            
                            
                                    if (localCUSER==null){
                                         throw new org.apache.axis2.databinding.ADBException("CUSER cannot be null!!");
                                    }
                                    elementList.add(localCUSER);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CDATE"));
                            
                            
                                    if (localCDATE==null){
                                         throw new org.apache.axis2.databinding.ADBException("CDATE cannot be null!!");
                                    }
                                    elementList.add(localCDATE);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CTIME"));
                            
                            
                                    if (localCTIME==null){
                                         throw new org.apache.axis2.databinding.ADBException("CTIME cannot be null!!");
                                    }
                                    elementList.add(localCTIME);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MUSER"));
                            
                            
                                    if (localMUSER==null){
                                         throw new org.apache.axis2.databinding.ADBException("MUSER cannot be null!!");
                                    }
                                    elementList.add(localMUSER);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MDATE"));
                            
                            
                                    if (localMDATE==null){
                                         throw new org.apache.axis2.databinding.ADBException("MDATE cannot be null!!");
                                    }
                                    elementList.add(localMDATE);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MTIME"));
                            
                            
                                    if (localMTIME==null){
                                         throw new org.apache.axis2.databinding.ADBException("MTIME cannot be null!!");
                                    }
                                    elementList.add(localMTIME);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZC"));
                            
                            
                                    if (localZC==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZC cannot be null!!");
                                    }
                                    elementList.add(localZC);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZSI"));
                            
                            
                                    if (localZSI==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZSI cannot be null!!");
                                    }
                                    elementList.add(localZSI);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZMN"));
                            
                            
                                    if (localZMN==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZMN cannot be null!!");
                                    }
                                    elementList.add(localZMN);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZP"));
                            
                            
                                    if (localZP==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZP cannot be null!!");
                                    }
                                    elementList.add(localZP);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZS"));
                            
                            
                                    if (localZS==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZS cannot be null!!");
                                    }
                                    elementList.add(localZS);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZCR"));
                            
                            
                                    if (localZCR==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZCR cannot be null!!");
                                    }
                                    elementList.add(localZCR);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZNI"));
                            
                            
                                    if (localZNI==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZNI cannot be null!!");
                                    }
                                    elementList.add(localZNI);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZMO"));
                            
                            
                                    if (localZMO==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZMO cannot be null!!");
                                    }
                                    elementList.add(localZMO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZCU"));
                            
                            
                                    if (localZCU==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZCU cannot be null!!");
                                    }
                                    elementList.add(localZCU);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZV"));
                            
                            
                                    if (localZV==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZV cannot be null!!");
                                    }
                                    elementList.add(localZV);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZAL"));
                            
                            
                                    if (localZAL==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZAL cannot be null!!");
                                    }
                                    elementList.add(localZAL);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZNB"));
                            
                            
                                    if (localZNB==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZNB cannot be null!!");
                                    }
                                    elementList.add(localZNB);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZW"));
                            
                            
                                    if (localZW==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZW cannot be null!!");
                                    }
                                    elementList.add(localZW);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZZN"));
                            
                            
                                    if (localZZN==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZZN cannot be null!!");
                                    }
                                    elementList.add(localZZN);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZTI"));
                            
                            
                                    if (localZTI==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZTI cannot be null!!");
                                    }
                                    elementList.add(localZTI);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZZR"));
                            
                            
                                    if (localZZR==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZZR cannot be null!!");
                                    }
                                    elementList.add(localZZR);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZN"));
                            
                            
                                    if (localZN==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZN cannot be null!!");
                                    }
                                    elementList.add(localZN);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZTA1"));
                            
                            
                                    if (localZTA1==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZTA1 cannot be null!!");
                                    }
                                    elementList.add(localZTA1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZTS"));
                            
                            
                                    if (localZTS==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZTS cannot be null!!");
                                    }
                                    elementList.add(localZTS);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZYS"));
                            
                            
                                    if (localZYS==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZYS cannot be null!!");
                                    }
                                    elementList.add(localZYS);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZE"));
                            
                            
                                    if (localZE==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZE cannot be null!!");
                                    }
                                    elementList.add(localZE);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZR"));
                            
                            
                                    if (localZR==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZR cannot be null!!");
                                    }
                                    elementList.add(localZR);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZHB"));
                            
                            
                                    if (localZHB==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZHB cannot be null!!");
                                    }
                                    elementList.add(localZHB);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZJ"));
                            
                            
                                    if (localZJ==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZJ cannot be null!!");
                                    }
                                    elementList.add(localZJ);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZJ1"));
                            
                            
                                    if (localZJ1==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZJ1 cannot be null!!");
                                    }
                                    elementList.add(localZJ1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZJ2"));
                            
                            
                                    if (localZJ2==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZJ2 cannot be null!!");
                                    }
                                    elementList.add(localZJ2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZFE"));
                            
                            
                                    if (localZFE==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZFE cannot be null!!");
                                    }
                                    elementList.add(localZFE);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZB"));
                            
                            
                                    if (localZB==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZB cannot be null!!");
                                    }
                                    elementList.add(localZB);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZUSER1"));
                            
                            
                                    if (localZUSER1==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZUSER1 cannot be null!!");
                                    }
                                    elementList.add(localZUSER1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZUSER2"));
                            
                            
                                    if (localZUSER2==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZUSER2 cannot be null!!");
                                    }
                                    elementList.add(localZUSER2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZUSER3"));
                            
                            
                                    if (localZUSER3==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZUSER3 cannot be null!!");
                                    }
                                    elementList.add(localZUSER3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZCD"));
                            
                            
                                    if (localZCD==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZCD cannot be null!!");
                                    }
                                    elementList.add(localZCD);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "LIFNR"));
                            
                            
                                    if (localLIFNR==null){
                                         throw new org.apache.axis2.databinding.ADBException("LIFNR cannot be null!!");
                                    }
                                    elementList.add(localLIFNR);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MEMO"));
                            
                            
                                    if (localMEMO==null){
                                         throw new org.apache.axis2.databinding.ADBException("MEMO cannot be null!!");
                                    }
                                    elementList.add(localMEMO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMP1"));
                            
                            
                                    if (localTEMP1==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMP1 cannot be null!!");
                                    }
                                    elementList.add(localTEMP1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "HOLD1"));
                            
                            
                                    if (localHOLD1==null){
                                         throw new org.apache.axis2.databinding.ADBException("HOLD1 cannot be null!!");
                                    }
                                    elementList.add(localHOLD1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMP2"));
                            
                            
                                    if (localTEMP2==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMP2 cannot be null!!");
                                    }
                                    elementList.add(localTEMP2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "HOLD2"));
                            
                            
                                    if (localHOLD2==null){
                                         throw new org.apache.axis2.databinding.ADBException("HOLD2 cannot be null!!");
                                    }
                                    elementList.add(localHOLD2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMP3"));
                            
                            
                                    if (localTEMP3==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMP3 cannot be null!!");
                                    }
                                    elementList.add(localTEMP3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "HOLD3"));
                            
                            
                                    if (localHOLD3==null){
                                         throw new org.apache.axis2.databinding.ADBException("HOLD3 cannot be null!!");
                                    }
                                    elementList.add(localHOLD3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMP4"));
                            
                            
                                    if (localTEMP4==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMP4 cannot be null!!");
                                    }
                                    elementList.add(localTEMP4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "HOLD4"));
                            
                            
                                    if (localHOLD4==null){
                                         throw new org.apache.axis2.databinding.ADBException("HOLD4 cannot be null!!");
                                    }
                                    elementList.add(localHOLD4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "VT"));
                            
                            
                                    if (localVT==null){
                                         throw new org.apache.axis2.databinding.ADBException("VT cannot be null!!");
                                    }
                                    elementList.add(localVT);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PT"));
                            
                            
                                    if (localPT==null){
                                         throw new org.apache.axis2.databinding.ADBException("PT cannot be null!!");
                                    }
                                    elementList.add(localPT);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MT"));
                            
                            
                                    if (localMT==null){
                                         throw new org.apache.axis2.databinding.ADBException("MT cannot be null!!");
                                    }
                                    elementList.add(localMT);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "RT"));
                            
                            
                                    if (localRT==null){
                                         throw new org.apache.axis2.databinding.ADBException("RT cannot be null!!");
                                    }
                                    elementList.add(localRT);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "UT"));
                            
                            
                                    if (localUT==null){
                                         throw new org.apache.axis2.databinding.ADBException("UT cannot be null!!");
                                    }
                                    elementList.add(localUT);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MCLASS"));
                            
                            
                                    if (localMCLASS==null){
                                         throw new org.apache.axis2.databinding.ADBException("MCLASS cannot be null!!");
                                    }
                                    elementList.add(localMCLASS);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMPER1"));
                            
                            
                                    if (localTEMPER1==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMPER1 cannot be null!!");
                                    }
                                    elementList.add(localTEMPER1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TIME1"));
                            
                            
                                    if (localTIME1==null){
                                         throw new org.apache.axis2.databinding.ADBException("TIME1 cannot be null!!");
                                    }
                                    elementList.add(localTIME1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMPER2"));
                            
                            
                                    if (localTEMPER2==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMPER2 cannot be null!!");
                                    }
                                    elementList.add(localTEMPER2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PRE"));
                            
                            
                                    if (localPRE==null){
                                         throw new org.apache.axis2.databinding.ADBException("PRE cannot be null!!");
                                    }
                                    elementList.add(localPRE);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TIME2"));
                            
                            
                                    if (localTIME2==null){
                                         throw new org.apache.axis2.databinding.ADBException("TIME2 cannot be null!!");
                                    }
                                    elementList.add(localTIME2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "POST"));
                            
                            
                                    if (localPOST==null){
                                         throw new org.apache.axis2.databinding.ADBException("POST cannot be null!!");
                                    }
                                    elementList.add(localPOST);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMPER3"));
                            
                            
                                    if (localTEMPER3==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMPER3 cannot be null!!");
                                    }
                                    elementList.add(localTEMPER3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TIME3"));
                            
                            
                                    if (localTIME3==null){
                                         throw new org.apache.axis2.databinding.ADBException("TIME3 cannot be null!!");
                                    }
                                    elementList.add(localTIME3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMPER4"));
                            
                            
                                    if (localTEMPER4==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMPER4 cannot be null!!");
                                    }
                                    elementList.add(localTEMPER4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TIME4"));
                            
                            
                                    if (localTIME4==null){
                                         throw new org.apache.axis2.databinding.ADBException("TIME4 cannot be null!!");
                                    }
                                    elementList.add(localTIME4);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMPER5"));
                            
                            
                                    if (localTEMPER5==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMPER5 cannot be null!!");
                                    }
                                    elementList.add(localTEMPER5);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TIME5"));
                            
                            
                                    if (localTIME5==null){
                                         throw new org.apache.axis2.databinding.ADBException("TIME5 cannot be null!!");
                                    }
                                    elementList.add(localTIME5);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMPER6"));
                            
                            
                                    if (localTEMPER6==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMPER6 cannot be null!!");
                                    }
                                    elementList.add(localTEMPER6);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TIME6"));
                            
                            
                                    if (localTIME6==null){
                                         throw new org.apache.axis2.databinding.ADBException("TIME6 cannot be null!!");
                                    }
                                    elementList.add(localTIME6);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEMPER7"));
                            
                            
                                    if (localTEMPER7==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEMPER7 cannot be null!!");
                                    }
                                    elementList.add(localTEMPER7);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TIME7"));
                            
                            
                                    if (localTIME7==null){
                                         throw new org.apache.axis2.databinding.ADBException("TIME7 cannot be null!!");
                                    }
                                    elementList.add(localTIME7);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SB"));
                            
                            
                                    if (localSB==null){
                                         throw new org.apache.axis2.databinding.ADBException("SB cannot be null!!");
                                    }
                                    elementList.add(localSB);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CO"));
                            
                            
                                    if (localCO==null){
                                         throw new org.apache.axis2.databinding.ADBException("CO cannot be null!!");
                                    }
                                    elementList.add(localCO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FG"));
                            
                            
                                    if (localFG==null){
                                         throw new org.apache.axis2.databinding.ADBException("FG cannot be null!!");
                                    }
                                    elementList.add(localFG);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZYS2"));
                            
                            
                                    if (localZYS2==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZYS2 cannot be null!!");
                                    }
                                    elementList.add(localZYS2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZSN"));
                            
                            
                                    if (localZSN==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZSN cannot be null!!");
                                    }
                                    elementList.add(localZSN);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZSB"));
                            
                            
                                    if (localZSB==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZSB cannot be null!!");
                                    }
                                    elementList.add(localZSB);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZAS"));
                            
                            
                                    if (localZAS==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZAS cannot be null!!");
                                    }
                                    elementList.add(localZAS);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZER"));
                            
                            
                                    if (localZER==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZER cannot be null!!");
                                    }
                                    elementList.add(localZER);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZFF"));
                            
                            
                                    if (localZFF==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZFF cannot be null!!");
                                    }
                                    elementList.add(localZFF);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZQTR"));
                            
                            
                                    if (localZQTR==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZQTR cannot be null!!");
                                    }
                                    elementList.add(localZQTR);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CJ"));
                            
                            
                                    if (localCJ==null){
                                         throw new org.apache.axis2.databinding.ADBException("CJ cannot be null!!");
                                    }
                                    elementList.add(localCJ);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CJ_AVG"));
                            
                            
                                    if (localCJ_AVG==null){
                                         throw new org.apache.axis2.databinding.ADBException("CJ_AVG cannot be null!!");
                                    }
                                    elementList.add(localCJ_AVG);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CJ_MIN"));
                            
                            
                                    if (localCJ_MIN==null){
                                         throw new org.apache.axis2.databinding.ADBException("CJ_MIN cannot be null!!");
                                    }
                                    elementList.add(localCJ_MIN);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MARKING"));
                            
                            
                                    if (localMARKING==null){
                                         throw new org.apache.axis2.databinding.ADBException("MARKING cannot be null!!");
                                    }
                                    elementList.add(localMARKING);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "P_RNAF"));
                            
                            
                                    if (localP_RNAF==null){
                                         throw new org.apache.axis2.databinding.ADBException("P_RNAF cannot be null!!");
                                    }
                                    elementList.add(localP_RNAF);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PREN"));
                            
                            
                                    if (localPREN==null){
                                         throw new org.apache.axis2.databinding.ADBException("PREN cannot be null!!");
                                    }
                                    elementList.add(localPREN);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BATCH_NO"));
                            
                            
                                    if (localBATCH_NO==null){
                                         throw new org.apache.axis2.databinding.ADBException("BATCH_NO cannot be null!!");
                                    }
                                    elementList.add(localBATCH_NO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FURN1"));
                            
                            
                                    if (localFURN1==null){
                                         throw new org.apache.axis2.databinding.ADBException("FURN1 cannot be null!!");
                                    }
                                    elementList.add(localFURN1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FURN2"));
                            
                            
                                    if (localFURN2==null){
                                         throw new org.apache.axis2.databinding.ADBException("FURN2 cannot be null!!");
                                    }
                                    elementList.add(localFURN2);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FURN3"));
                            
                            
                                    if (localFURN3==null){
                                         throw new org.apache.axis2.databinding.ADBException("FURN3 cannot be null!!");
                                    }
                                    elementList.add(localFURN3);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CUSTO"));
                            
                            
                                    if (localCUSTO==null){
                                         throw new org.apache.axis2.databinding.ADBException("CUSTO cannot be null!!");
                                    }
                                    elementList.add(localCUSTO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZAI"));
                            
                            
                                    if (localZAI==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZAI cannot be null!!");
                                    }
                                    elementList.add(localZAI);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZTCRE"));
                            
                            
                                    if (localZTCRE==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZTCRE cannot be null!!");
                                    }
                                    elementList.add(localZTCRE);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MEMO1"));
                            
                            
                                    if (localMEMO1==null){
                                         throw new org.apache.axis2.databinding.ADBException("MEMO1 cannot be null!!");
                                    }
                                    elementList.add(localMEMO1);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TEXTURE"));
                            
                            
                                    if (localTEXTURE==null){
                                         throw new org.apache.axis2.databinding.ADBException("TEXTURE cannot be null!!");
                                    }
                                    elementList.add(localTEXTURE);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZH"));
                            
                            
                                    if (localZH==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZH cannot be null!!");
                                    }
                                    elementList.add(localZH);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZO"));
                            
                            
                                    if (localZO==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZO cannot be null!!");
                                    }
                                    elementList.add(localZO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZZFE"));
                            
                            
                                    if (localZZFE==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZZFE cannot be null!!");
                                    }
                                    elementList.add(localZZFE);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZTA"));
                            
                            
                                    if (localZTA==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZTA cannot be null!!");
                                    }
                                    elementList.add(localZTA);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZCA"));
                            
                            
                                    if (localZCA==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZCA cannot be null!!");
                                    }
                                    elementList.add(localZCA);
                                

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
        public static ZLUHAO parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZLUHAO object =
                new ZLUHAO();

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
                    
                            if (!"ZLUHAO".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZLUHAO)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MANDT").equals(reader.getName())){
                                
                                                object.setMANDT(Clnt3.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZCZ").equals(reader.getName())){
                                
                                                object.setZCZ(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","LUHAO").equals(reader.getName())){
                                
                                                object.setLUHAO(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","STOCH").equals(reader.getName())){
                                
                                                object.setSTOCH(Char6.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZDEL").equals(reader.getName())){
                                
                                                object.setZDEL(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CUSER").equals(reader.getName())){
                                
                                                object.setCUSER(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CDATE").equals(reader.getName())){
                                
                                                object.setCDATE(Date10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CTIME").equals(reader.getName())){
                                
                                                object.setCTIME(Time.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MUSER").equals(reader.getName())){
                                
                                                object.setMUSER(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MDATE").equals(reader.getName())){
                                
                                                object.setMDATE(Date10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MTIME").equals(reader.getName())){
                                
                                                object.setMTIME(Time.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZC").equals(reader.getName())){
                                
                                                object.setZC(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZSI").equals(reader.getName())){
                                
                                                object.setZSI(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZMN").equals(reader.getName())){
                                
                                                object.setZMN(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZP").equals(reader.getName())){
                                
                                                object.setZP(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZS").equals(reader.getName())){
                                
                                                object.setZS(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZCR").equals(reader.getName())){
                                
                                                object.setZCR(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZNI").equals(reader.getName())){
                                
                                                object.setZNI(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZMO").equals(reader.getName())){
                                
                                                object.setZMO(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZCU").equals(reader.getName())){
                                
                                                object.setZCU(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZV").equals(reader.getName())){
                                
                                                object.setZV(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZAL").equals(reader.getName())){
                                
                                                object.setZAL(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZNB").equals(reader.getName())){
                                
                                                object.setZNB(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZW").equals(reader.getName())){
                                
                                                object.setZW(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZZN").equals(reader.getName())){
                                
                                                object.setZZN(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZTI").equals(reader.getName())){
                                
                                                object.setZTI(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZZR").equals(reader.getName())){
                                
                                                object.setZZR(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZN").equals(reader.getName())){
                                
                                                object.setZN(Quantum184.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZTA1").equals(reader.getName())){
                                
                                                object.setZTA1(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZTS").equals(reader.getName())){
                                
                                                object.setZTS(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZYS").equals(reader.getName())){
                                
                                                object.setZYS(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZE").equals(reader.getName())){
                                
                                                object.setZE(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZR").equals(reader.getName())){
                                
                                                object.setZR(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZHB").equals(reader.getName())){
                                
                                                object.setZHB(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZJ").equals(reader.getName())){
                                
                                                object.setZJ(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZJ1").equals(reader.getName())){
                                
                                                object.setZJ1(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZJ2").equals(reader.getName())){
                                
                                                object.setZJ2(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZFE").equals(reader.getName())){
                                
                                                object.setZFE(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZB").equals(reader.getName())){
                                
                                                object.setZB(Quantum184.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZUSER1").equals(reader.getName())){
                                
                                                object.setZUSER1(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZUSER2").equals(reader.getName())){
                                
                                                object.setZUSER2(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZUSER3").equals(reader.getName())){
                                
                                                object.setZUSER3(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZCD").equals(reader.getName())){
                                
                                                object.setZCD(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","LIFNR").equals(reader.getName())){
                                
                                                object.setLIFNR(Char10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MEMO").equals(reader.getName())){
                                
                                                object.setMEMO(Char100.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMP1").equals(reader.getName())){
                                
                                                object.setTEMP1(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","HOLD1").equals(reader.getName())){
                                
                                                object.setHOLD1(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMP2").equals(reader.getName())){
                                
                                                object.setTEMP2(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","HOLD2").equals(reader.getName())){
                                
                                                object.setHOLD2(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMP3").equals(reader.getName())){
                                
                                                object.setTEMP3(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","HOLD3").equals(reader.getName())){
                                
                                                object.setHOLD3(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMP4").equals(reader.getName())){
                                
                                                object.setTEMP4(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","HOLD4").equals(reader.getName())){
                                
                                                object.setHOLD4(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","VT").equals(reader.getName())){
                                
                                                object.setVT(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PT").equals(reader.getName())){
                                
                                                object.setPT(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MT").equals(reader.getName())){
                                
                                                object.setMT(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","RT").equals(reader.getName())){
                                
                                                object.setRT(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","UT").equals(reader.getName())){
                                
                                                object.setUT(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MCLASS").equals(reader.getName())){
                                
                                                object.setMCLASS(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMPER1").equals(reader.getName())){
                                
                                                object.setTEMPER1(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TIME1").equals(reader.getName())){
                                
                                                object.setTIME1(Quantum181.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMPER2").equals(reader.getName())){
                                
                                                object.setTEMPER2(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PRE").equals(reader.getName())){
                                
                                                object.setPRE(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TIME2").equals(reader.getName())){
                                
                                                object.setTIME2(Quantum181.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","POST").equals(reader.getName())){
                                
                                                object.setPOST(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMPER3").equals(reader.getName())){
                                
                                                object.setTEMPER3(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TIME3").equals(reader.getName())){
                                
                                                object.setTIME3(Quantum181.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMPER4").equals(reader.getName())){
                                
                                                object.setTEMPER4(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TIME4").equals(reader.getName())){
                                
                                                object.setTIME4(Quantum181.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMPER5").equals(reader.getName())){
                                
                                                object.setTEMPER5(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TIME5").equals(reader.getName())){
                                
                                                object.setTIME5(Quantum181.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMPER6").equals(reader.getName())){
                                
                                                object.setTEMPER6(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TIME6").equals(reader.getName())){
                                
                                                object.setTIME6(Quantum181.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEMPER7").equals(reader.getName())){
                                
                                                object.setTEMPER7(Quantum180.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TIME7").equals(reader.getName())){
                                
                                                object.setTIME7(Quantum181.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SB").equals(reader.getName())){
                                
                                                object.setSB(Char18.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CO").equals(reader.getName())){
                                
                                                object.setCO(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FG").equals(reader.getName())){
                                
                                                object.setFG(Char1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZYS2").equals(reader.getName())){
                                
                                                object.setZYS2(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZSN").equals(reader.getName())){
                                
                                                object.setZSN(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZSB").equals(reader.getName())){
                                
                                                object.setZSB(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZAS").equals(reader.getName())){
                                
                                                object.setZAS(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZER").equals(reader.getName())){
                                
                                                object.setZER(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZFF").equals(reader.getName())){
                                
                                                object.setZFF(Char18.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZQTR").equals(reader.getName())){
                                
                                                object.setZQTR(Char18.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CJ").equals(reader.getName())){
                                
                                                object.setCJ(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CJ_AVG").equals(reader.getName())){
                                
                                                object.setCJ_AVG(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CJ_MIN").equals(reader.getName())){
                                
                                                object.setCJ_MIN(Char15.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MARKING").equals(reader.getName())){
                                
                                                object.setMARKING(Char200.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","P_RNAF").equals(reader.getName())){
                                
                                                object.setP_RNAF(Char200.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PREN").equals(reader.getName())){
                                
                                                object.setPREN(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BATCH_NO").equals(reader.getName())){
                                
                                                object.setBATCH_NO(Char10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FURN1").equals(reader.getName())){
                                
                                                object.setFURN1(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FURN2").equals(reader.getName())){
                                
                                                object.setFURN2(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FURN3").equals(reader.getName())){
                                
                                                object.setFURN3(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CUSTO").equals(reader.getName())){
                                
                                                object.setCUSTO(Char40.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZAI").equals(reader.getName())){
                                
                                                object.setZAI(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZTCRE").equals(reader.getName())){
                                
                                                object.setZTCRE(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MEMO1").equals(reader.getName())){
                                
                                                object.setMEMO1(Char100.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TEXTURE").equals(reader.getName())){
                                
                                                object.setTEXTURE(Char40.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZH").equals(reader.getName())){
                                
                                                object.setZH(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZO").equals(reader.getName())){
                                
                                                object.setZO(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZZFE").equals(reader.getName())){
                                
                                                object.setZZFE(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZTA").equals(reader.getName())){
                                
                                                object.setZTA(Quantum183.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZCA").equals(reader.getName())){
                                
                                                object.setZCA(Quantum183.Factory.parse(reader));
                                              
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
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "ZHZZ".equals(typeName)){
                   
                            return  ZHZZ.Factory.parse(reader);
                        

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
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "quantum18.0".equals(typeName)){
                   
                            return  Quantum180.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "quantum18.1".equals(typeName)){
                   
                            return  Quantum181.Factory.parse(reader);
                        

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
                  "clnt3".equals(typeName)){
                   
                            return  Clnt3.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char6".equals(typeName)){
                   
                            return  Char6.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "date10".equals(typeName)){
                   
                            return  Date10.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "ZLUHAO".equals(typeName)){
                   
                            return  ZLUHAO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char5".equals(typeName)){
                   
                            return  Char5.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char18".equals(typeName)){
                   
                            return  Char18.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char15".equals(typeName)){
                   
                            return  Char15.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char1".equals(typeName)){
                   
                            return  Char1.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char200".equals(typeName)){
                   
                            return  Char200.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char10".equals(typeName)){
                   
                            return  Char10.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "TABLE_OF_ZLUHAO".equals(typeName)){
                   
                            return  TABLE_OF_ZLUHAO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "char100".equals(typeName)){
                   
                            return  Char100.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "TABLE_OF_ZHZZ".equals(typeName)){
                   
                            return  TABLE_OF_ZHZZ.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "time".equals(typeName)){
                   
                            return  Time.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

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
           
          
        public static class TABLE_OF_ZLUHAO
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = TABLE_OF_ZLUHAO
                Namespace URI = urn:sap-com:document:sap:rfc:functions
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Item
                        * This was an Array!
                        */

                        
                                    protected ZLUHAO[] localItem ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localItemTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return ZLUHAO[]
                           */
                           public  ZLUHAO[] getItem(){
                               return localItem;
                           }

                           
                        


                               
                              /**
                               * validate the array for Item
                               */
                              protected void validateItem(ZLUHAO[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Item
                              */
                              public void setItem(ZLUHAO[] param){
                              
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
                             * @param param ZLUHAO
                             */
                             public void addItem(ZLUHAO param){
                                   if (localItem == null){
                                   localItem = new ZLUHAO[]{};
                                   }

                            
                                 //update the setting tracker
                                localItemTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localItem);
                               list.add(param);
                               this.localItem =
                             (ZLUHAO[])list.toArray(
                            new ZLUHAO[list.size()]);

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
                       TABLE_OF_ZLUHAO.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":TABLE_OF_ZLUHAO",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "TABLE_OF_ZLUHAO",
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
        public static TABLE_OF_ZLUHAO parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            TABLE_OF_ZLUHAO object =
                new TABLE_OF_ZLUHAO();

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
                    
                            if (!"TABLE_OF_ZLUHAO".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (TABLE_OF_ZLUHAO)ExtensionMapper.getTypeObject(
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
                                    list1.add(ZLUHAO.Factory.parse(reader));
                                                                
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
                                                                    list1.add(ZLUHAO.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone1 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setItem((ZLUHAO[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                ZLUHAO.class,
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
           
          
        public static class ZHZZ
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ZHZZ
                Namespace URI = urn:sap-com:document:sap:rfc:functions
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for MANDT
                        */

                        
                                    protected Clnt3 localMANDT ;
                                

                           /**
                           * Auto generated getter method
                           * @return Clnt3
                           */
                           public  Clnt3 getMANDT(){
                               return localMANDT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MANDT
                               */
                               public void setMANDT(Clnt3 param){
                            
                                            this.localMANDT=param;
                                    

                               }
                            

                        /**
                        * field for ZCZ
                        */

                        
                                    protected Char25 localZCZ ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getZCZ(){
                               return localZCZ;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZCZ
                               */
                               public void setZCZ(Char25 param){
                            
                                            this.localZCZ=param;
                                    

                               }
                            

                        /**
                        * field for LUHAO
                        */

                        
                                    protected Char20 localLUHAO ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getLUHAO(){
                               return localLUHAO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LUHAO
                               */
                               public void setLUHAO(Char20 param){
                            
                                            this.localLUHAO=param;
                                    

                               }
                            

                        /**
                        * field for MATNR
                        */

                        
                                    protected Char18 localMATNR ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char18
                           */
                           public  Char18 getMATNR(){
                               return localMATNR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MATNR
                               */
                               public void setMATNR(Char18 param){
                            
                                            this.localMATNR=param;
                                    

                               }
                            

                        /**
                        * field for CC
                        */

                        
                                    protected Char20 localCC ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getCC(){
                               return localCC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CC
                               */
                               public void setCC(Char20 param){
                            
                                            this.localCC=param;
                                    

                               }
                            

                        /**
                        * field for HZZDW
                        */

                        
                                    protected Char5 localHZZDW ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char5
                           */
                           public  Char5 getHZZDW(){
                               return localHZZDW;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HZZDW
                               */
                               public void setHZZDW(Char5 param){
                            
                                            this.localHZZDW=param;
                                    

                               }
                            

                        /**
                        * field for SCZH
                        */

                        
                                    protected Char10 localSCZH ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char10
                           */
                           public  Char10 getSCZH(){
                               return localSCZH;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SCZH
                               */
                               public void setSCZH(Char10 param){
                            
                                            this.localSCZH=param;
                                    

                               }
                            

                        /**
                        * field for ERDAT
                        */

                        
                                    protected Date10 localERDAT ;
                                

                           /**
                           * Auto generated getter method
                           * @return Date10
                           */
                           public  Date10 getERDAT(){
                               return localERDAT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ERDAT
                               */
                               public void setERDAT(Date10 param){
                            
                                            this.localERDAT=param;
                                    

                               }
                            

                        /**
                        * field for CUSER
                        */

                        
                                    protected Char20 localCUSER ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getCUSER(){
                               return localCUSER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CUSER
                               */
                               public void setCUSER(Char20 param){
                            
                                            this.localCUSER=param;
                                    

                               }
                            

                        /**
                        * field for MUSER
                        */

                        
                                    protected Char20 localMUSER ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getMUSER(){
                               return localMUSER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MUSER
                               */
                               public void setMUSER(Char20 param){
                            
                                            this.localMUSER=param;
                                    

                               }
                            

                        /**
                        * field for AEDAT
                        */

                        
                                    protected Date10 localAEDAT ;
                                

                           /**
                           * Auto generated getter method
                           * @return Date10
                           */
                           public  Date10 getAEDAT(){
                               return localAEDAT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AEDAT
                               */
                               public void setAEDAT(Date10 param){
                            
                                            this.localAEDAT=param;
                                    

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
                       ZHZZ.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ZHZZ",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZHZZ",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localMANDT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MANDT cannot be null!!");
                                            }
                                           localMANDT.serialize(new javax.xml.namespace.QName("","MANDT"),
                                               factory,xmlWriter);
                                        
                                            if (localZCZ==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZCZ cannot be null!!");
                                            }
                                           localZCZ.serialize(new javax.xml.namespace.QName("","ZCZ"),
                                               factory,xmlWriter);
                                        
                                            if (localLUHAO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("LUHAO cannot be null!!");
                                            }
                                           localLUHAO.serialize(new javax.xml.namespace.QName("","LUHAO"),
                                               factory,xmlWriter);
                                        
                                            if (localMATNR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MATNR cannot be null!!");
                                            }
                                           localMATNR.serialize(new javax.xml.namespace.QName("","MATNR"),
                                               factory,xmlWriter);
                                        
                                            if (localCC==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CC cannot be null!!");
                                            }
                                           localCC.serialize(new javax.xml.namespace.QName("","CC"),
                                               factory,xmlWriter);
                                        
                                            if (localHZZDW==null){
                                                 throw new org.apache.axis2.databinding.ADBException("HZZDW cannot be null!!");
                                            }
                                           localHZZDW.serialize(new javax.xml.namespace.QName("","HZZDW"),
                                               factory,xmlWriter);
                                        
                                            if (localSCZH==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SCZH cannot be null!!");
                                            }
                                           localSCZH.serialize(new javax.xml.namespace.QName("","SCZH"),
                                               factory,xmlWriter);
                                        
                                            if (localERDAT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ERDAT cannot be null!!");
                                            }
                                           localERDAT.serialize(new javax.xml.namespace.QName("","ERDAT"),
                                               factory,xmlWriter);
                                        
                                            if (localCUSER==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CUSER cannot be null!!");
                                            }
                                           localCUSER.serialize(new javax.xml.namespace.QName("","CUSER"),
                                               factory,xmlWriter);
                                        
                                            if (localMUSER==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MUSER cannot be null!!");
                                            }
                                           localMUSER.serialize(new javax.xml.namespace.QName("","MUSER"),
                                               factory,xmlWriter);
                                        
                                            if (localAEDAT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AEDAT cannot be null!!");
                                            }
                                           localAEDAT.serialize(new javax.xml.namespace.QName("","AEDAT"),
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
                                                                      "MANDT"));
                            
                            
                                    if (localMANDT==null){
                                         throw new org.apache.axis2.databinding.ADBException("MANDT cannot be null!!");
                                    }
                                    elementList.add(localMANDT);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZCZ"));
                            
                            
                                    if (localZCZ==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZCZ cannot be null!!");
                                    }
                                    elementList.add(localZCZ);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "LUHAO"));
                            
                            
                                    if (localLUHAO==null){
                                         throw new org.apache.axis2.databinding.ADBException("LUHAO cannot be null!!");
                                    }
                                    elementList.add(localLUHAO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MATNR"));
                            
                            
                                    if (localMATNR==null){
                                         throw new org.apache.axis2.databinding.ADBException("MATNR cannot be null!!");
                                    }
                                    elementList.add(localMATNR);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CC"));
                            
                            
                                    if (localCC==null){
                                         throw new org.apache.axis2.databinding.ADBException("CC cannot be null!!");
                                    }
                                    elementList.add(localCC);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "HZZDW"));
                            
                            
                                    if (localHZZDW==null){
                                         throw new org.apache.axis2.databinding.ADBException("HZZDW cannot be null!!");
                                    }
                                    elementList.add(localHZZDW);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SCZH"));
                            
                            
                                    if (localSCZH==null){
                                         throw new org.apache.axis2.databinding.ADBException("SCZH cannot be null!!");
                                    }
                                    elementList.add(localSCZH);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ERDAT"));
                            
                            
                                    if (localERDAT==null){
                                         throw new org.apache.axis2.databinding.ADBException("ERDAT cannot be null!!");
                                    }
                                    elementList.add(localERDAT);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CUSER"));
                            
                            
                                    if (localCUSER==null){
                                         throw new org.apache.axis2.databinding.ADBException("CUSER cannot be null!!");
                                    }
                                    elementList.add(localCUSER);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MUSER"));
                            
                            
                                    if (localMUSER==null){
                                         throw new org.apache.axis2.databinding.ADBException("MUSER cannot be null!!");
                                    }
                                    elementList.add(localMUSER);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "AEDAT"));
                            
                            
                                    if (localAEDAT==null){
                                         throw new org.apache.axis2.databinding.ADBException("AEDAT cannot be null!!");
                                    }
                                    elementList.add(localAEDAT);
                                

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
        public static ZHZZ parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZHZZ object =
                new ZHZZ();

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
                    
                            if (!"ZHZZ".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZHZZ)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MANDT").equals(reader.getName())){
                                
                                                object.setMANDT(Clnt3.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZCZ").equals(reader.getName())){
                                
                                                object.setZCZ(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","LUHAO").equals(reader.getName())){
                                
                                                object.setLUHAO(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MATNR").equals(reader.getName())){
                                
                                                object.setMATNR(Char18.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CC").equals(reader.getName())){
                                
                                                object.setCC(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","HZZDW").equals(reader.getName())){
                                
                                                object.setHZZDW(Char5.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SCZH").equals(reader.getName())){
                                
                                                object.setSCZH(Char10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ERDAT").equals(reader.getName())){
                                
                                                object.setERDAT(Date10.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CUSER").equals(reader.getName())){
                                
                                                object.setCUSER(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MUSER").equals(reader.getName())){
                                
                                                object.setMUSER(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","AEDAT").equals(reader.getName())){
                                
                                                object.setAEDAT(Date10.Factory.parse(reader));
                                              
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
           
          
        public static class Char18
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char18",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char18
                        */

                        
                                    protected java.lang.String localChar18 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar18(){
                               return localChar18;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char18
                               */
                               public void setChar18(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 18)  ) {
                                                this.localChar18=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar18.toString();
                                    
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
                       Char18.this.serialize(MY_QNAME,factory,xmlWriter);
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
                                           namespacePrefix+":char18",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char18",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar18==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar18);
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar18)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char18 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char18 returnValue = new  Char18();
                    
                            returnValue.setChar18(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char18 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char18.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char18.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char18 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char18 object =
                new Char18();

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
                                    
                                              object.setChar18(
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
           
          
        public static class Char6
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "char6",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Char6
                        */

                        
                                    protected java.lang.String localChar6 ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChar6(){
                               return localChar6;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Char6
                               */
                               public void setChar6(java.lang.String param){
                            
                                            if (  (java.lang.String.valueOf(param).length() <= 6)  ) {
                                                this.localChar6=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localChar6.toString();
                                    
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
                       Char6.this.serialize(MY_QNAME,factory,xmlWriter);
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
                                           namespacePrefix+":char6",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "char6",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localChar6==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(localChar6);
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChar6)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Char6 fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Char6 returnValue = new  Char6();
                    
                            returnValue.setChar6(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static Char6 fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Char6.Factory.fromString(content,namespaceUri);
                    } else {
                       return Char6.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Char6 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Char6 object =
                new Char6();

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
                                    
                                              object.setChar6(
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
           
          
        public static class Time
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "time",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Time
                        */

                        
                                    protected org.apache.axis2.databinding.types.Time localTime ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.apache.axis2.databinding.types.Time
                           */
                           public  org.apache.axis2.databinding.types.Time getTime(){
                               return localTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Time
                               */
                               public void setTime(org.apache.axis2.databinding.types.Time param){
                            
                                            if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")) {
                                                this.localTime=param;
                                            }
                                            else {
                                                throw new java.lang.RuntimeException();
                                            }
                                        

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localTime.toString();
                                    
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
                       Time.this.serialize(MY_QNAME,factory,xmlWriter);
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
                                           namespacePrefix+":time",
                                           xmlWriter);
                                   } else {
                                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                                           "time",
                                           xmlWriter);
                                   }
                               }
                            
                                          if (localTime==null){
                                            
                                                     throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
                                                
                                         }else{
                                        
                                                       xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTime));
                                            
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
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTime)
                            },
                            null);

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static Time fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    Time returnValue = new  Time();
                    
                            returnValue.setTime(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToTime(value));
                        

                    return returnValue;
                }

                public static Time fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return Time.Factory.fromString(content,namespaceUri);
                    } else {
                       return Time.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Time parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Time object =
                new Time();

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
                                    
                                              object.setTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToTime(content));
                                            
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
           
          
        public static class TABLE_OF_ZHZZ
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = TABLE_OF_ZHZZ
                Namespace URI = urn:sap-com:document:sap:rfc:functions
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Item
                        * This was an Array!
                        */

                        
                                    protected ZHZZ[] localItem ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localItemTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return ZHZZ[]
                           */
                           public  ZHZZ[] getItem(){
                               return localItem;
                           }

                           
                        


                               
                              /**
                               * validate the array for Item
                               */
                              protected void validateItem(ZHZZ[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Item
                              */
                              public void setItem(ZHZZ[] param){
                              
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
                             * @param param ZHZZ
                             */
                             public void addItem(ZHZZ param){
                                   if (localItem == null){
                                   localItem = new ZHZZ[]{};
                                   }

                            
                                 //update the setting tracker
                                localItemTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localItem);
                               list.add(param);
                               this.localItem =
                             (ZHZZ[])list.toArray(
                            new ZHZZ[list.size()]);

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
                       TABLE_OF_ZHZZ.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":TABLE_OF_ZHZZ",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "TABLE_OF_ZHZZ",
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
        public static TABLE_OF_ZHZZ parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            TABLE_OF_ZHZZ object =
                new TABLE_OF_ZHZZ();

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
                    
                            if (!"TABLE_OF_ZHZZ".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (TABLE_OF_ZHZZ)ExtensionMapper.getTypeObject(
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
                                    list1.add(ZHZZ.Factory.parse(reader));
                                                                
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
                                                                    list1.add(ZHZZ.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone1 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setItem((ZHZZ[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                ZHZZ.class,
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
           
          
        public static class ZWEBS_ZLUHAO1
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "ZWEBS_ZLUHAO1",
                "ns1");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for L_LUHAO
                        */

                        
                                    protected Char20 localL_LUHAO ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char20
                           */
                           public  Char20 getL_LUHAO(){
                               return localL_LUHAO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param L_LUHAO
                               */
                               public void setL_LUHAO(Char20 param){
                            
                                            this.localL_LUHAO=param;
                                    

                               }
                            

                        /**
                        * field for L_ZCZ
                        */

                        
                                    protected Char25 localL_ZCZ ;
                                

                           /**
                           * Auto generated getter method
                           * @return Char25
                           */
                           public  Char25 getL_ZCZ(){
                               return localL_ZCZ;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param L_ZCZ
                               */
                               public void setL_ZCZ(Char25 param){
                            
                                            this.localL_ZCZ=param;
                                    

                               }
                            

                        /**
                        * field for ZMTR_ZHZZ
                        */

                        
                                    protected TABLE_OF_ZHZZ localZMTR_ZHZZ ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localZMTR_ZHZZTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return TABLE_OF_ZHZZ
                           */
                           public  TABLE_OF_ZHZZ getZMTR_ZHZZ(){
                               return localZMTR_ZHZZ;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZMTR_ZHZZ
                               */
                               public void setZMTR_ZHZZ(TABLE_OF_ZHZZ param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localZMTR_ZHZZTracker = true;
                                       } else {
                                          localZMTR_ZHZZTracker = false;
                                              
                                       }
                                   
                                            this.localZMTR_ZHZZ=param;
                                    

                               }
                            

                        /**
                        * field for ZMTR_ZLUHAO
                        */

                        
                                    protected TABLE_OF_ZLUHAO localZMTR_ZLUHAO ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localZMTR_ZLUHAOTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return TABLE_OF_ZLUHAO
                           */
                           public  TABLE_OF_ZLUHAO getZMTR_ZLUHAO(){
                               return localZMTR_ZLUHAO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZMTR_ZLUHAO
                               */
                               public void setZMTR_ZLUHAO(TABLE_OF_ZLUHAO param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localZMTR_ZLUHAOTracker = true;
                                       } else {
                                          localZMTR_ZLUHAOTracker = false;
                                              
                                       }
                                   
                                            this.localZMTR_ZLUHAO=param;
                                    

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
                       ZWEBS_ZLUHAO1.this.serialize(MY_QNAME,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ZWEBS_ZLUHAO1",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZWEBS_ZLUHAO1",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localL_LUHAO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("L_LUHAO cannot be null!!");
                                            }
                                           localL_LUHAO.serialize(new javax.xml.namespace.QName("","L_LUHAO"),
                                               factory,xmlWriter);
                                        
                                            if (localL_ZCZ==null){
                                                 throw new org.apache.axis2.databinding.ADBException("L_ZCZ cannot be null!!");
                                            }
                                           localL_ZCZ.serialize(new javax.xml.namespace.QName("","L_ZCZ"),
                                               factory,xmlWriter);
                                         if (localZMTR_ZHZZTracker){
                                            if (localZMTR_ZHZZ==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZMTR_ZHZZ cannot be null!!");
                                            }
                                           localZMTR_ZHZZ.serialize(new javax.xml.namespace.QName("","ZMTR_ZHZZ"),
                                               factory,xmlWriter);
                                        } if (localZMTR_ZLUHAOTracker){
                                            if (localZMTR_ZLUHAO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZMTR_ZLUHAO cannot be null!!");
                                            }
                                           localZMTR_ZLUHAO.serialize(new javax.xml.namespace.QName("","ZMTR_ZLUHAO"),
                                               factory,xmlWriter);
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

                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "L_LUHAO"));
                            
                            
                                    if (localL_LUHAO==null){
                                         throw new org.apache.axis2.databinding.ADBException("L_LUHAO cannot be null!!");
                                    }
                                    elementList.add(localL_LUHAO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "L_ZCZ"));
                            
                            
                                    if (localL_ZCZ==null){
                                         throw new org.apache.axis2.databinding.ADBException("L_ZCZ cannot be null!!");
                                    }
                                    elementList.add(localL_ZCZ);
                                 if (localZMTR_ZHZZTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZMTR_ZHZZ"));
                            
                            
                                    if (localZMTR_ZHZZ==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZMTR_ZHZZ cannot be null!!");
                                    }
                                    elementList.add(localZMTR_ZHZZ);
                                } if (localZMTR_ZLUHAOTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZMTR_ZLUHAO"));
                            
                            
                                    if (localZMTR_ZLUHAO==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZMTR_ZLUHAO cannot be null!!");
                                    }
                                    elementList.add(localZMTR_ZLUHAO);
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
        public static ZWEBS_ZLUHAO1 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZWEBS_ZLUHAO1 object =
                new ZWEBS_ZLUHAO1();

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
                    
                            if (!"ZWEBS_ZLUHAO1".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZWEBS_ZLUHAO1)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","L_LUHAO").equals(reader.getName())){
                                
                                                object.setL_LUHAO(Char20.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","L_ZCZ").equals(reader.getName())){
                                
                                                object.setL_ZCZ(Char25.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZMTR_ZHZZ").equals(reader.getName())){
                                
                                                object.setZMTR_ZHZZ(TABLE_OF_ZHZZ.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZMTR_ZLUHAO").equals(reader.getName())){
                                
                                                object.setZMTR_ZLUHAO(TABLE_OF_ZLUHAO.Factory.parse(reader));
                                              
                                        reader.next();
                                    
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
           
          
            private  org.apache.axiom.om.OMElement  toOM(ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1 param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1 param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1.MY_QNAME,factory));
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
        
                if (ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1.class.equals(type)){
                
                           return ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response.class.equals(type)){
                
                           return ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   