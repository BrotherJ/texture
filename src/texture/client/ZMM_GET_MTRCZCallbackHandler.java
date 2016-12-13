
/**
 * ZMM_GET_MTRCZCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */

    package texture.client;

    /**
     *  ZMM_GET_MTRCZCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ZMM_GET_MTRCZCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ZMM_GET_MTRCZCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ZMM_GET_MTRCZCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for ZMM_GET_MTRCZ method
            * override this method for handling normal response from ZMM_GET_MTRCZ operation
            */
           public void receiveResultZMM_GET_MTRCZ(
                    ZMM_GET_MTRCZStub.ZMM_GET_MTRCZResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from ZMM_GET_MTRCZ operation
           */
            public void receiveErrorZMM_GET_MTRCZ(java.lang.Exception e) {
            }
                


    }
    