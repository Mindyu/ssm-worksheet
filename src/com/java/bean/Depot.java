package com.java.bean;

public class Depot {
    private Integer depotno;

    private String depotName;

    private String loc;

    public Integer getDepotno() {
        return depotno;
    }

    public void setDepotno(Integer depotno) {
        this.depotno = depotno;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName == null ? null : depotName.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

	@Override
	public String toString() {
		return "Depot [depotno=" + depotno + ", depotName=" + depotName + ", loc=" + loc + "]";
	}
    
}