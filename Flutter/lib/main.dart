import 'dart:ui';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:jobs/pages/register.dart';
import 'package:jobs/pages/demo.dart';


void main() async {
  runApp(MaterialApp(
    initialRoute: "/home",
    routes: {
      "/home":(context)=>Demo(),
      "/register":(context)=>Register(),
    },
  ));
}




