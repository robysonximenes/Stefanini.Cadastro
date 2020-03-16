
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for autenticarFuncionario complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="autenticarFuncionario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inAutenticarFuncionario" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}inAutenticarFuncionario" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autenticarFuncionario", propOrder = {
    "inAutenticarFuncionario"
})
public class AutenticarFuncionario {

    protected InAutenticarFuncionario inAutenticarFuncionario;

    /**
     * Gets the value of the inAutenticarFuncionario property.
     * 
     * @return
     *     possible object is
     *     {@link InAutenticarFuncionario }
     *     
     */
    public InAutenticarFuncionario getInAutenticarFuncionario() {
        return inAutenticarFuncionario;
    }

    /**
     * Sets the value of the inAutenticarFuncionario property.
     * 
     * @param value
     *     allowed object is
     *     {@link InAutenticarFuncionario }
     *     
     */
    public void setInAutenticarFuncionario(InAutenticarFuncionario value) {
        this.inAutenticarFuncionario = value;
    }

}
