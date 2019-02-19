using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTestMusic
{
    [TestClass]
    public class UnitTestPlayList
    {
        [TestMethod]
        public void IsNextSongCorrect() {
            var songs = new Playlist();
            song.Main.op = 1;
            song.Main.newSong = "1. La catedra";
            song.Main.op = 1;
            song.Main.newSong = "2. Mis disculpas";
            Assert.AreEqual(songs.head.next.name, songs.tail.name);
        }

        [TestMethod]
        public void IsPrevSongCorrect() {
            var songs = new Playlist();
            song.Main.op = 1;
            song.Main.newSong = "1. Desencuentro";
            song.Main.op = 1;
            song.Main.newSong = "2. Querido Louis";
            Assert.AreEqual(songs.head.prev.name, songs.tail.name);
        }

        [TestMethod]
        public void PrintsPlayList() {
            var songs = new Playlist();
            String list;
            for (int i=0; i<3; i++) {
                song.Main.op = 1;
                song.Main.newSong = $"Song {i}";
                list += $"Song {i}\n";
            }
            song.Main.op = 5;
            Console.WriteLine(list);
        }
    }
}
