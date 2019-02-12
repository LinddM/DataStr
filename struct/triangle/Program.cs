using System;

namespace Shapes
{
    class Program
    {
        public struct triangle
        {
            public int b;
            public int h;
        }
        static void Main(string[] args)
        {
            triangle tri;

            Console.Write("Area of a triangle\nBase: ");
            tri.b=Int16.Parse(Console.ReadLine());
            Console.Write("Height: ");
            tri.h=Int16.Parse(Console.ReadLine());

            Console.WriteLine($"Area: {area(tri)}");
        }
        public static int area(triangle tri){
            int a=tri.h*tri.b/2;
            return a;
        }
    }
}
