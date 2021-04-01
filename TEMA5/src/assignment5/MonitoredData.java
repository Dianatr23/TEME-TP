package assignment5;

public class MonitoredData {
	private String startTime;
	private String endTime;
	private String activity;
	
	public MonitoredData(String start, String end, String act) {
		startTime = start;
		endTime = end;
		activity = act;
	}
	
	public String toString() {
		return this.startTime + "  " + this.endTime +  "  " + this.activity;	
	}
	
	public String getStartTime() {
		return this.startTime;
	}
	
	public String getEndTime() {
		return this.endTime;
	}
	
	public String getActivity() {
		return this.activity;
	}
	
	public void setActivity(String a) {
		this.activity = a;
	}
}
