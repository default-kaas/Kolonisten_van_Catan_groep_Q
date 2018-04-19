package Model;

public class ResourceCards {
	private char ResourceType;
	private String ResourceID;
	public ResourceCards(char RecourseType, String ResourceID) {
		this.ResourceType = ResourceType;
		this.ResourceID = ResourceID;
	}
	public String getID() {
		// TODO Auto-generated method stub
		return ResourceID;
	}
}
