package peopleAndAddresses;

public interface DAOPeople extends DAO<Person>{
    default Person increaseAge(Person person, int num){
        person.setAge(person.getAge() + num);
        return person;
    }
}
