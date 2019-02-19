using System;
using System.Collections.Generic;

namespace Nodes
{
    class Program
    {
        public struct node{
            public int health;
            public String name;
        }
        static void Main(string[] args)
        {
            LinkedList<node> nodes = new LinkedList<node>();
            node thisNode;
            Random NodeHealth = new Random();

            int op=0, check=0;

            do{
                Console.Write("\n1. Add node\n2. Mark unhealthy node\n3. Check nodes\n4. Remove an unhealthy node\n0. Exit\n");
                op=Int16.Parse(Console.ReadLine());

                switch(op){

                    case 1:
                    Console.WriteLine("\nEnter new node's name: ");
                    thisNode.name=Console.ReadLine();
                    thisNode.health=NodeHealth.Next(1);

                    if(nodes.Count<3){
                        nodes.AddLast(thisNode);
                    }else{
                        nodes=sortNodes(nodes, thisNode);
                    }
                    break;

                    case 2:
                    if(nodes!=null){
                        Console.WriteLine("\nEnter unhealthy node's name: ");
                        thisNode.name=Console.ReadLine();
                        thisNode.health=1;
                        markUnhealthy(nodes, thisNode);
                        sortNodes(nodes, thisNode);
                    }
                    break;
                    
                    case 3:
                    Console.WriteLine("\n0: healthy | 1: unhealthy\n");
                    foreach(var n in nodes)
                        Console.WriteLine($"{n.name} is {n.health}");

                    check++;
                    break;

                    case 4:
                    if(check> 2){
                        foreach (node n in nodes){
                            if (n.health == 1){
                                nodes.Remove(n);
                                break;
                            }
                        }
                    }else{
                        Console.WriteLine("'Remove unhealthy node' option not available yet");
                    }
                    break;
                }
                
            }while(op!=0);

        }
        static LinkedList<node> sortNodes(LinkedList<node> nodes, node newNode){
            bool hasSide=false;
            foreach(node oldNode in nodes){
                if(oldNode.health == newNode.health){
                    nodes.AddAfter(nodes.Find(oldNode), newNode);
                    hasSide=true;
                    break;
                }
            }
            if(hasSide==false){
                nodes.AddLast(newNode);
            }

            return nodes;
        }

        static void markUnhealthy(LinkedList<node> nodes, node newNode){
            bool existingNode=false;
            foreach(node n in nodes){
                if(n.name.Equals(newNode.name)){
                    nodes.Remove(n);
                    existingNode=true;
                    break;
                }
            }
            if(!existingNode){
                Console.WriteLine("Invalid node name");
            }
        }
    }
}