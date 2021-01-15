package vn.zalopay.jmeter.grpc.client;

import java.beans.PropertyDescriptor;
import vn.zalopay.jmeter.grpc.utils.Config;
import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.TypeEditor;

public class GrpcClientSamplerBeanInfo extends BeanInfoSupport {

  private static final String UNDEFINDED = "notUndefined";
  private static final String DEFAULT = "default";

  private void setPropertyDescriptor(String propName, Object obj) {
    PropertyDescriptor props = property(propName);
    props.setValue(UNDEFINDED, Boolean.TRUE);
    props.setValue(DEFAULT, obj);
  }

  public GrpcClientSamplerBeanInfo() {
    super(GrpcClientSampler.class);

    createPropertyGroup("Server",
        new String[] { "hostname", "port", "useSsl", "certFile", "clientKeyCertChainFile", "clientKeyFile" });
    createPropertyGroup("Service", new String[] { "packageN", "service" });
    createPropertyGroup("Execute", new String[] { "method", "request", "timeout", "metaData", "requestBuilderCode" });

    PropertyDescriptor props = property("requestBuilderCode", TypeEditor.TextAreaEditor);
    props.setValue(UNDEFINDED, Boolean.TRUE);
    props.setValue("textLanguage", "java");
    props.setValue(DEFAULT, Config.REQUEST_CODE);

    props = property("clientKeyCertChainFile", TypeEditor.FileEditor);
    props.setValue(UNDEFINDED, Config.CLIENT_KEY_CERT_CHAIN_FILE);
    props.setValue(DEFAULT, Config.CLIENT_KEY_CERT_CHAIN_FILE);

    props = property("clientKeyFile", TypeEditor.FileEditor);
    props.setValue(UNDEFINDED, Config.CLIENT_KEY_FILE);
    props.setValue(DEFAULT, Config.CLIENT_KEY_FILE);

    props = property("certFile", TypeEditor.FileEditor);
    props.setValue(UNDEFINDED, Config.CERT_FILE);
    props.setValue(DEFAULT, Config.CERT_FILE);

    setPropertyDescriptor("hostname", Config.HOST_NAME);
    setPropertyDescriptor("port", Config.PORT);
    setPropertyDescriptor("useSsl", Config.USE_SSL);
    setPropertyDescriptor("packageN", Config.PACKAGE_NAME);
    setPropertyDescriptor("service", Config.SERVICE);
    setPropertyDescriptor("method", Config.METHOD);
    setPropertyDescriptor("request", Config.REQUEST);
    setPropertyDescriptor("timeout", Config.TIME_OUT);
    setPropertyDescriptor("metaData", Config.META_DATA);
  }
}
