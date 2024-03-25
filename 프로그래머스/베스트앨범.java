import java.util.*;

class SongData {
    String genre;
    int play;
    int index;

    public SongData(String genre, int play, int index) {
        this.genre = genre;
        this.play = play;
        this.index = index;
    }
}

class Solution {
    int i;

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, ArrayList<SongData>> songMap = new HashMap<>();

        for (i = 0; i < genres.length; i++) {
            String key = genres[i];

            if (!sumMap.containsKey(key)) {
                // SongData 자료형을 가지는 ArrayList 생성
                ArrayList<SongData> songArr = new ArrayList<>();
                // song 인스턴스를 선언하고 이를 ArrayList에 add
                SongData song = new SongData(genres[i], plays[i], i);
                songArr.add(song);

                sumMap.put(key, plays[i]);
                songMap.put(key, songArr);
            } else {
                int replaceSum = sumMap.get(key) + plays[i];
                // 기존의 SongArr를 가져와서 갱신하고 replace
                ArrayList<SongData> replaceSongArr = songMap.get(key);
                SongData song = new SongData(genres[i], plays[i], i);
                replaceSongArr.add(song);

                sumMap.replace(key, replaceSum);
                songMap.replace(key, replaceSongArr);
            }
        }

        // sumMap을 Sort하여 Genre들의 List로 저장
        // Map.Entry를 이용하면 Map에 저장된 모든 key-value 쌍을 각각의 key-value를 갖고 있는 하나의 객체로 얻을 수 있다
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(sumMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // 정렬된 EntryList를 처음부터 순회하며 많이 재생된 장르부터 검사
        ArrayList<SongData> nowSongList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            // 정렬된 Entry의 Key를 통해 SongMap을 가져온다
            nowSongList = songMap.get(entry.getKey());
            Collections.sort(nowSongList, new Comparator<SongData>() {
                @Override
                public int compare(SongData s1, SongData s2) {
                    if (s1.play == s2.play)
                        return s1.index - s2.index;
                    return s2.play - s1.play;
                }
            });

            int cnt = 0;
            for (SongData nowSong : nowSongList) {
                if (cnt == 2)
                    break;
                answer.add(nowSong.index);
                cnt++;
            }
        }

        // ArrayList를 Integer Array로 변환하여 반환
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
