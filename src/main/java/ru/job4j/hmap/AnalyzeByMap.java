package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        double totalSubjects = 0;
        for (Pupil avePupils : pupils) {
            for (Subject scoreSubject : avePupils.subjects()) {
                totalScore += scoreSubject.score();
                totalSubjects++;
            }
        }
        return totalScore / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil avePupils : pupils) {
            double pupilScore = 0;
            double totalSubjects = 0;
            for (Subject scoreSub : avePupils.subjects()) {
                totalSubjects++;
                pupilScore += scoreSub.score();
            }
            double average = pupilScore / totalSubjects;
            Label label = new Label(avePupils.name(), average);
            result.add(label);
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        Map<String, Integer> subjectCounts = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();
                subjectScores.put(subjectName, subjectScores.getOrDefault(subjectName, 0) + score);
                subjectCounts.put(subjectName, subjectCounts.getOrDefault(subjectName, 0) + 1);
            }
        }
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();
            int studentCount = subjectCounts.get(subjectName);
            double averageScore = (double) totalScore / studentCount;
            Label subjectLabel = new Label(subjectName, averageScore);
            result.add(subjectLabel);
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> bestStudent = new ArrayList<>();
        for (Pupil avePupils : pupils) {
            double pupilScore = 0;
            for (Subject scoreSub : avePupils.subjects()) {
                pupilScore += scoreSub.score();
            }
            bestStudent.add(new Label(avePupils.name(), pupilScore));
        }
        bestStudent.sort(Comparator.naturalOrder());
        return bestStudent.get(bestStudent.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                double score = subject.score();
                subjectScores.put(subjectName, subjectScores.getOrDefault(subjectName, 0.0) + score);
            }
        }
        List<Label> subjectLabels = new ArrayList<>();
        for (Map.Entry<String, Double> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            double totalScore = entry.getValue();
            subjectLabels.add(new Label(subjectName, totalScore));
        }
        subjectLabels.sort(Comparator.naturalOrder());
        return subjectLabels.get(subjectLabels.size() - 1);
    }
}
