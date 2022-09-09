import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class stream_filter {

    // https://howtodoinjava.com/java8/java-stream-filter-example/
    public static void main(String args[]) {
        List<Entity> entityList = new ArrayList<>();
        entityList.add(new Entity(1, "a"));
        entityList.add(new Entity(2, "a"));
        entityList.add(new Entity(1, "b"));
        entityList.add(new Entity(2, "c"));

        // filter
        List<Entity> outList = entityList.stream().filter(e -> "a".equals(e.getName())).collect(Collectors.toList());
        System.out.println(outList.toString());

        //lambda
        entityList.stream().filter(e -> "a".equals(e.getName())).forEach(System.out::println);

        //map
        outList = entityList.stream().filter(e -> "a".equals(e.getName())).map(e -> e.setId(e.getId() * 2)).collect(Collectors.toList());
        System.out.println(outList.toString());

        // self condition
        outList = entityList.stream().filter(new Predicate<Entity>() {
            @Override
            public boolean test(Entity entity) {
                if ("b".equals(entity.getName())){
                    return true;
                }
                return false;
            }
        }).collect(Collectors.toList());
        System.out.println(outList.toString());
    }

    public static class Entity {
        public double id;
        public String name;

        public double getId() {
            return id;
        }

        public Entity setId(double id) {
            this.id = id;
            return this;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Entity(double id, String name) {
            this.id = id;
            this.name = name;
        }


    }
}
