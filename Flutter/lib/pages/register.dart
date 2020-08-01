
import 'dart:ui';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class Register extends StatefulWidget {
  @override
  _RegisterState createState() => _RegisterState();
}

class _RegisterState extends State<Register> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body:SingleChildScrollView(
        child:SafeArea(
          child:Column(
            children: <Widget>[
              Text("Sign Up",
                style: TextStyle(
                  fontSize: 30,
                  fontWeight: FontWeight.bold,
                  color: Colors.grey[500]
                ),
              ),
              SizedBox(height:20),
              Container(
                padding: EdgeInsets.only(left:10,right:10,bottom: 30,top: 50),
//                child: Form(
//
//                ),
              )
            ],
          )
        )
      )
    );
  }
}
