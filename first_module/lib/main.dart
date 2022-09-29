import 'package:first_module/meme.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

@pragma("vm-entry-point")
void showCell() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        backgroundColor: Colors.green,
        scaffoldBackgroundColor: Colors.green
      ),
      debugShowCheckedModeBanner: false,
      home: SafeArea(
        child: Stack(
          children: const [Meme(), Meme()],
        ),
      ),
    );
  }
}
