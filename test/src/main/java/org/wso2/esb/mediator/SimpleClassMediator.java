package org.wso2.esb.mediator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;

public class SimpleClassMediator extends AbstractMediator {
    String resourcePath = "conf:/store/response.xsd";

    private static final Log log = LogFactory.getLog(SimpleClassMediator.class);



    public SimpleClassMediator(){}

    public boolean mediate(MessageContext mc) {
        // Do somthing useful..
        // To add a new resource for the registry
        mc.getConfiguration().getRegistry().newResource(resourcePath, false);
        // To update the registry
        mc.getConfiguration().getRegistry().updateResource(resourcePath, mc.getProperty("xsdContent").toString().getBytes());
        // Note the access to the Synapse Message context
        return true;
    }

    public String getType() {
        return null;
    }

    public void setTraceState(int traceState) {
        traceState = 0;
    }

    public int getTraceState() {
        return 0;
    }

    // Set the resource path
    public void setResourcePath(String resourcePath){ this.resourcePath=resourcePath; }

    // Get the resource path
    public String getResourcePath() {
        return resourcePath;
    }
}
