using System;

namespace Coord
{
    class Program
    {
        public struct Point
        {
            public int x;
            public int y;
        }
        static void Main(string[] args)
        {
            Point p;

            Console.Write("X coordinate: ");
            p.x = int.Parse(Console.ReadLine());
            
            Console.Write("Y coordinate: ");
            p.y = int.Parse(Console.ReadLine());

            Console.WriteLine(quadrant(p));
        }

        public static String quadrant(Point p)
        {
            String location="origin";
            if (p.x > 0)
            {
                if (p.y > 0)
                {
                    location="quadrant 1";
                }
                else
                {
                    location="quadrant 4";
                }
            }
            else
            {
                if (p.y > 0)
                {
                    location="quadrant 2";
                }
                else if (p.y < 0)
                {
                    location="quadrant 3";
                }
            }
            return location;
        }

    }
}
