using System;
using System.Collections.Generic;

namespace Btree
{
    //Containers have a list of (module) keys inside. Also, each container can have (module - 1) children
    //Needs to evaluate letters with less priority in the dictionary and rearrange the tree when keys exceed the module
    class Keys {
        public string value;
        public Keys(string data){
            this.value = data;
        }
        public char leftReference;
    }
    class Container {
        public List <Keys> keys = new List<Keys>();
        public List <Container> children = new List<Container>();
        public char rightReference;
    }
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter module");
            int module = Int16.Parse(Console.ReadLine());
            Container root = new Container();
            
            string text;
            using (var webClient = new System.Net.WebClient()){
                text = webClient.DownloadString("https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt");
            }
            string [] words = text.Split("\r");
            foreach(string word in words){
                root = setNode(root, word, module);
            }
        }

        public static Container setNode(Container node, string word, int module){   
            //Manage keys in a container
            if(node.keys.Count < module){
                //rearrange list of nodes inside container
                node = reArrangeKeys(node, word, module);
            }else{
                //evaluate references and create children
                //fix: check if theres any children instead of adding new children
                node.children.Add(compareKeys(node, word));
            }
            
            return node;
        }
        public static Container reArrangeKeys(Container node, string word, int module){
            //needs to check if there are children
            bool needsToArrange = true;
            if(node.keys.Count != 0 && node.keys.Count < module){
                foreach(Keys key in node.keys){
                    if(key.value[0] > word[0]){
                        int index = node.keys.IndexOf(key);
                        node.keys.Insert(index, new Keys(word){leftReference = word[0]});
                        needsToArrange = false;
                        break;
                    }
                }
                if(needsToArrange){
                    node.keys.Add(new Keys(word));
                }
            }else if(node.keys.Count == 0 && node.keys.Count < module){
                node.keys.Add(new Keys(word)); 
            }else{
                //rearrange the tree
            }
            return node;
        }
        public static Container compareKeys(Container node, string word){
            bool evaluateLastCase = true;
            Container newContainer = new Container();
            //checking just the first letter of both words (requirement: check all letters)
            foreach(Keys key in node.keys){              
                if(word[0] > key.leftReference){
                    newContainer.keys.Add(new Keys(word));
                    evaluateLastCase = false;
                }
            }

            if(evaluateLastCase){
                if(word[0] < node.rightReference){
                    newContainer.keys.Add(new Keys(word));
                }
            }
            return newContainer;
        }

        
    }
}