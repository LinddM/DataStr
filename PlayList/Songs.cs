using System;
namespace Music
{
    class Song {
        public String name;
        public Song prev;
        public Song next;
    }
    class Playlist {

        static void Main(string[] args) {
            int op=0;
            Song head = null;
            Song tail = null;
            int firstSong=0;
            do {
                Console.WriteLine("1. Add song\n2. Play Now\n3. Play Next song\n4. Play Previous song\n5. PlayList\n0. Exit");
                op = Int16.Parse(Console.ReadLine());

                switch (op) {
                    case 1:
                    //Set new song as head (always moving) and first input as tail (keeps the same value)
                        Console.WriteLine("New song: ");
                        String newSong=Console.ReadLine();
                        head = addSong(newSong, head, tail, firstSong);
                    //First song sets the next value of the tail
                        if (firstSong < 1) {
                            tail = head;
                            firstSong++;
                        } else {
                            tail.prev=head;
                        }
                        break;

                    case 2:
                    //Display head
                        Console.WriteLine(head.name);
                        break;

                    case 3:
                        head = head.next;
                        Console.WriteLine(head.name);
                        break;

                    case 4:
                        head = head.prev;
                        Console.WriteLine(head.name);
                        break;

                    case 5:
                    //Display song in head and moves
                        while (tail.name != head.name){
                            head = head.prev;
                            Console.WriteLine(head.name);
                        }
                        Console.WriteLine(head.prev.name);
                        break;
                }
            } while (op != 0);
        }

        public static Song addSong(String newSong, Song head, Song tail, int onlyOneSong) {
        //Set actual head as prev song and tail as next song. Changes next value in head as new value (so you can go backward)
            Song thisSong = new Song();
            thisSong.name = newSong;
            if (onlyOneSong < 1)
            {
                thisSong.prev = thisSong;
                thisSong.next = thisSong;
            } else {
                thisSong.prev = head;
                thisSong.next = tail;
                head.next = thisSong;
            }
            
            return thisSong;
        }
    }
}
