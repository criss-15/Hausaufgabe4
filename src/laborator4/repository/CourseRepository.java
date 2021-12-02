package laborator4.repository;//package lab3.lab3.repository.ICrudRepository
import laborator4.model.Course;


import java.util.List;


public class CourseRepository extends InMemoryRepository<Course> {

    private List<Course> courseList;

    @Override
    public String toString() {
        
        return "KursRepository{" +
                "kursList=" + courseList +
                '}';
    }

    public CourseRepository(List<Course> courseList) {

        this.courseList = courseList;
    }


    /**
     * Find one course.
     *
     * @param id the id
     * @return the course
     */
    public Course findOne(Long id) {
         for( Course k : courseList)
             if(k.getId().equals(id))
                 return k;
        return null;
    }


    /**
     * Find all courses.
     *
     * @return the list
     */
    public List<Course> findAll() {
        return courseList;
    }

    @Override
    public Course create(Course entity) {
        if(!courseList.contains(entity)) {
            courseList.add(entity);
            return null;
        }
        return entity;

    }


    /**
     * Delete course.
     *
     * @param id the id
     * @return the course
     */
    public Course delete(Long id) {
        Course k = findOne(id);
        if(k==null) {
            return null;
        }
        courseList.remove(k);
        return k;
    }

    @Override
    public Course update(Course entity) {
        long id= entity.getId();
        if(findOne(id)!=null){
            courseList.set(courseList.indexOf(findOne(id)),entity);
            return null;
        }
    return entity;

    }

}
