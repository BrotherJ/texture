
/**
 * ZWEBS_ZLUHAO1SERVICECallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */

    package texture.client;

    /**
     *  ZWEBS_ZLUHAO1SERVICECallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ZWEBS_ZLUHAO1SERVICECallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ZWEBS_ZLUHAO1SERVICECallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ZWEBS_ZLUHAO1SERVICECallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for ZWEBS_ZLUHAO1 method
            * override this method for handling normal response from ZWEBS_ZLUHAO1 operation
            */
           public void receiveResultZWEBS_ZLUHAO1(
                    ZWEBS_ZLUHAO1SERVICEStub.ZWEBS_ZLUHAO1Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from ZWEBS_ZLUHAO1 operation
           */
            public void receiveErrorZWEBS_ZLUHAO1(java.lang.Exception e) {
            }
                


    }
    