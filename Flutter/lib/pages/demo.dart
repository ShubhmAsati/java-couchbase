import 'dart:ui';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
class Demo extends StatefulWidget {
  @override
  _DemoState createState() => _DemoState();
}

class _DemoState extends State<Demo> {
  TextEditingController mobileController = TextEditingController();

  String textValue;

  bool valid = true;


  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onTap: () {
          FocusScopeNode currentFocus = FocusScope.of(context);

          if (!currentFocus.hasPrimaryFocus) {
            currentFocus.unfocus();
          }
        },
        child: Scaffold(
//      appBar: AppBar(
//        title: Center(
//          child: Text(
//            "Demo"
//          ),
//        ),
//        backgroundColor: Colors.grey,
//      ),
          resizeToAvoidBottomPadding: true,
          backgroundColor: Colors.white,
          body:SingleChildScrollView(
            child: SafeArea(
              child: Padding(
                padding: EdgeInsets.symmetric(horizontal: 20.0),
                child:Column(
                  mainAxisAlignment: MainAxisAlignment.start,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: <Widget>[
//                  CircleAvatar(
//                    backgroundImage: AssetImage("images/covi.jpg"),
//                    radius:40
//                  ),
//                  Container(
//                    padding: EdgeInsets.only(left:230),
//                    child: RaisedButton.icon(onPressed: (){
//                      setState(() {
//                          theme = theme?false:true;
//                          themeChanger = theme?Colors.white:Colors.black;
//                      });
//                    },
//                        icon: Icon(Icons.threed_rotation)
//                        , label: Text("Theme"),
//                      shape: RoundedRectangleBorder(
//                        borderRadius: BorderRadius.circular(30)
//                      ),
//                    ),
//                  ),
                    SizedBox(height: 20,),
                    Text(
                        "LOG IN",
                        style: TextStyle(
                            fontSize: 30,
                            fontWeight: FontWeight.bold,
                            color: Colors.grey[500]
                        )
                    ),
                    SizedBox(height:20.0),
//                    CircleAvatar(
//                      backgroundImage: AssetImage("images/covi.jpg"),
//                      radius: 20,
//                    ),
//                    SizedBox(height: 80,),
                    Container(
                      margin: EdgeInsets.only(top:80),
                      padding: EdgeInsets.only(left:10.0,right:10.0,bottom: 30,top: 50),
//                      decoration: BoxDecoration(
//                        color: Colors.grey[200],
//                        border: Border.all(
//                          color: Colors.black
//                        ),
//                        borderRadius: BorderRadius.circular(25.0)
//                      ),
//              margin: EdgeInsets.fromLTRB(35.0, 0.0, 0, 0),
                      child: Column(
                        children: <Widget>[
                          TextField(
                            autofocus: false,
                            keyboardType: TextInputType.number,
                            style: TextStyle(
                              color: Colors.black,
                            ),
                            decoration: InputDecoration(
                              contentPadding: EdgeInsets.all(20.0),
                              prefixIcon: Icon(Icons.phone,
                                color: Colors.grey,
                              ),
                              labelText: "Mobile No",
                              labelStyle: TextStyle(
                                  color: Colors.grey
                              ),
                              hintText: "Enter 10 digit Mobile Number",
                              hintStyle: TextStyle(
                                  color: Colors.grey
                              ),
                              fillColor: Colors.black,
                              enabledBorder:  OutlineInputBorder(
                                borderSide: BorderSide(
                                    color: Colors.teal[500],
                                    width: 2.0,
                                    style: BorderStyle.solid
                                ),
                                borderRadius: BorderRadius.circular(25.0),
                              ),
                              focusedBorder:  OutlineInputBorder(
                                borderSide: BorderSide(
                                    color: Colors.teal[500],
                                    width: 2.0,
                                    style: BorderStyle.solid
                                ),
                                borderRadius: BorderRadius.circular(25.0),
                              ),
                              border: OutlineInputBorder(
                                borderSide: BorderSide(
                                    color: Colors.red,
                                    width: 2.0,
                                    style: BorderStyle.solid
                                ),
                                borderRadius: BorderRadius.circular(25.0),
                              ),
                            ),
                            selectionWidthStyle: BoxWidthStyle.tight,
                            controller: mobileController,
                          ),
                          SizedBox(height: 15.0,),
                          Row(
                            mainAxisAlignment: MainAxisAlignment.end,
                            children: <Widget>[
                              RaisedButton(
                                onPressed: (){
                                  RegExp exp = RegExp(r"^[0-9]{10}$");
                                  bool validate = exp.hasMatch(mobileController.text);
                                  print(validate);
                                  setState(() {
                                    valid = validate;
                                  });
                                  return null;
                                },
                                disabledColor: Colors.grey,
                                color: Colors.teal[500],
                                shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(20.0)
                                ),
                                child: Row(
                                  children: <Widget>[
                                    Text("Next"),
                                    SizedBox(
                                      width: 5,
                                    ),
                                    Container(
                                      decoration: BoxDecoration(
                                          shape: BoxShape.circle,
                                          color: Colors.white
                                      ),
                                      child: Icon(
                                          Icons.arrow_forward
                                      ),
                                    )

                                  ],
                                ),
                              ),
                            ],
                          ),
                          SizedBox(height:10),
                          Row(
                            children: <Widget>[
                              Expanded(
                                child: Container(
                                  margin: EdgeInsets.only(left:10.0,right:20.0),
                                  child: Divider(
                                    height: 50,
                                    color: Colors.grey,
                                  ),
                                ),
                              ),
                              Text("OR",
                                style: TextStyle(
                                    color: Colors.grey
                                ),
                              ),
                              Expanded(
                                child: Container(
                                  margin: EdgeInsets.only(left:20.0,right:10.0),
                                  child: Divider(
                                    height: 50,
                                    color: Colors.grey,
                                  ),
                                ),
                              ),
                            ],
                          ),
                          Column(
                            crossAxisAlignment: CrossAxisAlignment.stretch,
                            children: <Widget>[
                              RaisedButton(
                                onPressed: (){
                                  Navigator.pushReplacementNamed(context, "/register");
                                },
                                color: Colors.teal[500],
                                child: Text(
                                    "Sign Up"
                                ),
                              ),
                            ],
                          ),
                        ],
                      ),
                    ),
                    SizedBox(height:20.0),
                  ],
                ),
              ),
            ),
          ),
//        floatingActionButton: FloatingActionButton(
//          backgroundColor: Colors.teal[500],
//          onPressed:(){
//            setState(() {
//              theme = theme?false:true;
//              themeChanger = theme?Colors.white:Colors.black;
//            });
//          },
//          child:Icon(
//            Icons.gradient,
//          )
//        ),
        )
    );
  }
}