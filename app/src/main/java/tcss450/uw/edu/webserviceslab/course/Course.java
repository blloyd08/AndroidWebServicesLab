package tcss450.uw.edu.webserviceslab.course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by blloy on 4/20/2017.
 */

public class Course implements Serializable {

    public static final String ID="id",SHORT_DESC="shortDesc",
        LONG_DESC="longDesc", PRE_REQS="prereqs";

    private String mCourseID;
    private String mShortDescription;
    private String mLongDescription;
    private String mPrereqs;

    public Course(String mCourseID, String mShortDescription, String mLongDescription, String mPrereqs) {
        this.mCourseID = mCourseID;
        this.mShortDescription = mShortDescription;
        this.mLongDescription = mLongDescription;
        this.mPrereqs = mPrereqs;
    }

    public static String parseCourseJSON(String courseJSON, List<Course> courseList){
        String reason = null;
        if(courseJSON !=null){
            try{
                JSONArray arr = new JSONArray(courseJSON);

                for(int i = 0; i<arr.length(); i++){
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID),obj.getString(Course.SHORT_DESC)
                        ,obj.getString(Course.LONG_DESC),obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }

            } catch(JSONException e){
                reason = "Unable to parse data, Reason: " + e.getMessage();
            }
        }
        return reason;
    }

    public String getCourseID() {
        return mCourseID;
    }

    public void setCourseID(String mCourseID) {
        this.mCourseID = mCourseID;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public String getLongDescription() {
        return mLongDescription;
    }

    public void setLongDescription(String mLongDescription) {
        this.mLongDescription = mLongDescription;
    }

    public String getPrereqs() {
        return mPrereqs;
    }

    public void setPrereqs(String mPrereqs) {
        this.mPrereqs = mPrereqs;
    }
}
