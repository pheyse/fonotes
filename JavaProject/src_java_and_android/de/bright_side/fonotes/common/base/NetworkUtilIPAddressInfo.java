package de.bright_side.fonotes.common.base;

public class NetworkUtilIPAddressInfo {
	private String address;
	private String displayName;
	private boolean loopBack;
	private boolean v4;
	private boolean virtual;
	private boolean pointToPoint;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public boolean isLoopBack() {
		return loopBack;
	}
	public void setLoopBack(boolean loopBack) {
		this.loopBack = loopBack;
	}
	public boolean isV4() {
		return v4;
	}
	public void setV4(boolean v4) {
		this.v4 = v4;
	}
	public boolean isVirtual() {
		return virtual;
	}
	public void setVirtual(boolean virtual) {
		this.virtual = virtual;
	}
	public boolean isPointToPoint() {
		return pointToPoint;
	}
	public void setPointToPoint(boolean pointToPoint) {
		this.pointToPoint = pointToPoint;
	}
}
