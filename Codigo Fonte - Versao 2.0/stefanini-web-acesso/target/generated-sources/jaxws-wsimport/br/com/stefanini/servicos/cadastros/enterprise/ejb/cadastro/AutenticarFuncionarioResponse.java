
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for autenticarFuncionarioResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="autenticarFuncionarioResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outAutenticarFuncionario" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}outAutenticarFuncionario" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autenticarFuncionarioResponse", propOrder = {
    "outAutenticarFuncionario"
})
public class AutenticarFuncionarioResponse {

    protected OutAutenticarFuncionario outAutenticarFuncionario;

    /**
     * Gets the value of the outAutenticarFuncionario property.
     * 
     * @return
     *     possible object is
     *     {@link OutAutenticarFuncionario }
     *     
     */
    public OutAutenticarFuncionario getOutAutenticarFuncionario() {
        return outAutenticarFuncionario;
    }

    /**
     * Sets the value of the outAutenticarFuncionario property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutAutenticarFuncionario }
     *     
     */
    public void setOutAutenticarFuncionario(OutAutenticarFuncionario value) {
        this.outAutenticarFuncionario = value;
    }

}
