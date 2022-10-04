package ru.itmo.lessons.lesson6.task1.mountaineering;

public class Group {
    private Mountain mountain;
    private Alpinist[] alpinists;
    private boolean isOpen = true;
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
        if(isOpen) System.out.println("Набор в группу открыт");
        else System.out.println("Набор в группу закрыт");
        return isOpen;
    }

    public void addAplinist(Alpinist alpinist) {
        if (isOpen) {
            alpinists[numberOfAlpinists] = alpinist;
            System.out.println("Альпинист " + alpinist.getName() + " добавлен в группу");
            numberOfAlpinists++;
        } else {
            System.out.println("Альпинист " + alpinist.getName() + " не добавлен в группу. Набор в группу закрыт");
        }
        if (numberOfAlpinists == maxAlpinists) isOpen = false;
    }
}
