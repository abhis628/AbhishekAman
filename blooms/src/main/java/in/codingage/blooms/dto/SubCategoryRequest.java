package in.codingage.blooms.dto;

public class SubCategoryRequest {

    public String id;
    private String CategoryId;
private String title;
private String desc;
private String cUrl;

  public SubCategoryRequest(String CategoryId,String title,String desc,String cUrl){
  this.CategoryId=CategoryId;
  this.title=title;
  this.desc=desc;
  this.cUrl=cUrl;
  }

    public String getId() {
        return CategoryId;
    }

    public void setId(String id) {
        this.CategoryId = id;
    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getcUrl() {
        return cUrl;
    }

    public void setcUrl(String cUrl) {
        this.cUrl = cUrl;
    }

    public String setTitle() {
      return  title;
    }

    public String getCategoryId() {
      return  id;
    }

    public String getName() {
      return title;
    }

    public String getDescription() {
    return getDescription();}
}
