/**
 * 
 */
package com.cloudhopper.smpp.type;

import org.jboss.netty.buffer.ChannelBuffer;

import com.cloudhopper.smpp.util.ChannelBufferUtil;

/**
 * @author Amit Bhayani
 * 
 */
public class UnsucessfulSME {

	private int errorStatusCode;
	private Address address;

	/**
	 * 
	 */
	public UnsucessfulSME() {
	}

	public UnsucessfulSME(int errorStatusCode, Address address) {
		super();
		this.errorStatusCode = errorStatusCode;
		this.address = address;
	}

	public int getErrorStatusCode() {
		return errorStatusCode;
	}

	public void setErrorStatusCode(int errorStatusCode) {
		this.errorStatusCode = errorStatusCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void read(ChannelBuffer buffer) throws UnrecoverablePduException,
			RecoverablePduException {
		this.address = ChannelBufferUtil.readAddress(buffer);
		this.errorStatusCode = buffer.readInt();
	}

	public void write(ChannelBuffer buffer) throws UnrecoverablePduException,
			RecoverablePduException {
		ChannelBufferUtil.writeAddress(buffer, this.address);
		buffer.writeInt(this.errorStatusCode);
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(44);
		buffer.append(this.address.toString());
		buffer.append(" errorStatusCode [");
		buffer.append(this.errorStatusCode);
		buffer.append("]");
		return buffer.toString();
	}

}
