
/**
 * ZWEBS_ZLUHAOServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */

    package texture.client;

    /**
     *  ZWEBS_ZLUHAOServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ZWEBS_ZLUHAOServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ZWEBS_ZLUHAOServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ZWEBS_ZLUHAOServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for ZWEBS_ZLUHAO method
            * override this method for handling normal response from ZWEBS_ZLUHAO operation
            */
           public void receiveResultZWEBS_ZLUHAO(
                    ZWEBS_ZLUHAOServiceStub.ZWEBS_ZLUHAOResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from ZWEBS_ZLUHAO operation
           */
            public void receiveErrorZWEBS_ZLUHAO(java.lang.Exception e) {
            }
                


    }
    