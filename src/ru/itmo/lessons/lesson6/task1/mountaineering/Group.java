package ru.itmo.lessons.lesson6.task1.mountaineering;

public class Group {
    private Mountain mountain;
    private Alpinist[] alpinists;
    private int maxAlpinists = 3;

    private int numberOfAlpinists = 0;

    public Group(Mountain mountain) {
        this.mountain = mountain;
        alpinists = new Alpinist[maxAlpinists];
    }

    public Mountain getMountain() {
        return mountain;
    }

    public Alpinist[] getAlpinists() {
        return alpinists;
    }

    public boolean isOpen() {
        return numberOfAlpinists < maxAlpinists;
    }

    public void printGroupInformation(){
        if(isOpen()) {
            System.out.println(
                    String.format("Группа для похода на гору %s. Набор открыт. Количество свободных мест: %d",
                            mountain.getName(), maxAlpinists - numberOfAlpinists));
        } else {
            System.out.println("Группа для похода на гору %s. Набор закрыт");
        }
    }

    public void addAplinist(Alpinist alpinist) {
        if (isOpen()) {
            alpinists[numberOfAlpinists] = alpinist;
            System.out.println(String.format(
                    "Альпинист %s добавлен в группу для похода на гору %s", alpinist.getName(), mountain.getName()));
            numberOfAlpinists++;
        } else {
            System.out.println(String.format(
                    "Альпинист %s не добавлен в группу для похода на гору %s. Группа заполенена",
                    alpinist.getName(), mountain.getName()));
        }
    }
}
