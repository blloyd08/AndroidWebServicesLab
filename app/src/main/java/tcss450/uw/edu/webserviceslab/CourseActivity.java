package tcss450.uw.edu.webserviceslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tcss450.uw.edu.webserviceslab.course.Course;

public class CourseActivity extends AppCompatActivity
implements CourseFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        if (findViewById(R.id.fragment_container) != null){
            if (savedInstanceState == null || getSupportFragmentManager().findFragmentById(R.id.list) == null) {
                CourseFragment courseFragment = new CourseFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, courseFragment)
                        .commit();
            }
        }
    }

    @Override
    public void onListFragmentInteraction(Course item) {

        CourseDetailFragment courseDetailFragment = (CourseDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.course_detail_frag);
        if (courseDetailFragment != null){
            courseDetailFragment.updateView(item);
        } else {
            courseDetailFragment = new CourseDetailFragment();
            Bundle args = new Bundle();
            args.putSerializable(CourseDetailFragment.COURSE_ITEM_SELECTED, item);
            courseDetailFragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, courseDetailFragment)
                    .addToBackStack(null)
                    .commit();
        }


    }

}
