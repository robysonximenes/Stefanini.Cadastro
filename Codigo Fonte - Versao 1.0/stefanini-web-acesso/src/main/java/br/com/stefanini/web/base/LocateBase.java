package br.com.stefanini.web.base;

import br.com.stefanini.web.util.PropertiesUtil;
import java.net.URL;
import java.util.Properties;
import javax.xml.namespace.QName;

/**
 * Stefanini 2020
 * @author Robyson Ximenes
 * Class Responsavel Por recuperar os url e wsdl no properties local do Web Service de Cadastro
 * @created 14/03/2020 - 17:58:03
 */
public abstract class LocateBase{

    public LocateBase(String appName, String fileName)
        throws Exception
    {
        lerPropriedades(appName, fileName);
    }

    private void lerPropriedades(String appName, String fileName)
        throws Exception
    {
        confWsLocator = (new PropertiesUtil()).getConf(appName, fileName);
    }

    public URL getURLWSDL(String serviceName)
        throws Exception
    {
        String endPoint;
        String localPartProperty = (new StringBuilder()).append(serviceName).append(".").append("url").toString();
        endPoint = confWsLocator.getProperty(localPartProperty);
        return new URL(endPoint);
    }

    public QName getNameSpaceURI(String localPart)
    {
        String namespaceURI = confWsLocator.getProperty((new StringBuilder()).append(localPart).append(".nameSpaceURI").toString());
        return new QName(namespaceURI, localPart);
    }

    public QName getNameSpaceURI(String servico, String localPart)
    {
        String namespaceURI = confWsLocator.getProperty((new StringBuilder()).append(servico).append(".nameSpaceURI").toString());
        return new QName(namespaceURI, localPart);
    }

    public String getEndPointAddress(String serviceName)
    {
        return confWsLocator.getProperty((new StringBuilder()).append(serviceName).append(".endPointAddress").toString());
    }

    public abstract Object get()
        throws Exception;

    static final String ENDPOINT_SUFFIX_URL = "url";
    public static Properties confWsLocator = null;

}