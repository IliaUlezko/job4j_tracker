package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static Map<String, Integer> getTemporaryMap(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subject();
            for (Subject subject : subjects) {
                map.merge(
                        subject.name(),
                        subject.score(),
                        (oldValue, newValue) -> oldValue + subject.score()
                );
            }
        }
        return map;
    }

    public static double averageScore(List<Pupil> pupils) {
        double average = 0D;
        int counter = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subject()) {
                average += subject.score();
                counter++;
            }
        }
        return average / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int counter = 0;
            int tempScore = 0;
            List<Subject> subjects = pupil.subject();
            for (Subject subject : subjects) {
                tempScore += subject.score();
                counter++;
            }

            Label label = new Label(pupil.name(), (double) tempScore / counter);
            list.add(label);
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = getTemporaryMap(pupils);

        for (String key : map.keySet()) {
            double result = (double) map.get(key) / (double) pupils.size();
            list.add(new Label(key, result));
        }

        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int data = 0;
            List<Subject> subjects = pupil.subject();
            for (Subject subject : subjects) {
                data += subject.score();
            }
            labels.add(new Label(pupil.name(), data));
        }
        Collections.sort(labels);
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = getTemporaryMap(pupils);
        for (String key : map.keySet()) {
            list.add(new Label(key, map.get(key)));
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
