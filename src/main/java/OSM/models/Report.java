package OSM.models;

public class Report {
    private int id;
    private String type, title, detail, date, value;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
