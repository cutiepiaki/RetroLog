package com.cutiepiaki.retrolog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.cutiepiaki.retrolog.ui.theme.RetroLogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetroLogTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Платформы",
                                modifier = Modifier.padding(innerPadding)
                            )

                            Row {
                                Button(
                                    shape = RectangleShape,
                                    onClick = { },
                                    contentPadding = PaddingValues(0.dp),
                                    modifier = Modifier
                                        .padding(horizontal = 5.dp)
                                        .width(130.dp)
                                        .height(150.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .weight(5f)
                                                .fillMaxWidth()
                                                .background(Color.Magenta),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("*IMAGE*")
                                        }

                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .fillMaxWidth(),
                                            contentAlignment = Alignment.BottomCenter
                                        ) {
                                            Text("GB")
                                        }
                                    }
                                }

                                Button(
                                    shape = RectangleShape,
                                    onClick = { },
                                    contentPadding = PaddingValues(0.dp),
                                    modifier = Modifier
                                        .padding(horizontal = 5.dp)
                                        .width(130.dp)
                                        .height(150.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxSize() // ← важно: Column должен занять всю кнопку
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .weight(5f)
                                                .fillMaxWidth()
                                                .background(Color.Magenta),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("*IMAGE*")
                                        }
                                        Box(
                                            modifier = Modifier.weight(1f),
                                            contentAlignment = Alignment.BottomCenter
                                        ) {
                                            Text("GBC")
                                        }
                                    }
                                }

                                Button(
                                    shape = RectangleShape,
                                    onClick = { },
                                    contentPadding = PaddingValues(0.dp),
                                    modifier = Modifier
                                        .padding(horizontal = 5.dp)
                                        .width(130.dp)
                                        .height(150.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxSize() // ← важно: Column должен занять всю кнопку
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .weight(5f)
                                                .fillMaxWidth()
                                                .background(Color.Magenta),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("*IMAGE*")
                                        }
                                        Box(
                                            modifier = Modifier.weight(1f),
                                            contentAlignment = Alignment.BottomCenter
                                        ) {
                                            Text("GBA")
                                        }
                                    }
                                }
                            }

                            Row(
                                modifier = Modifier.padding(vertical = 10.dp)
                            ) {
                                Button(
                                    shape = RectangleShape,
                                    onClick = { },
                                    contentPadding = PaddingValues(0.dp),
                                    modifier = Modifier
                                        .padding(horizontal = 5.dp)
                                        .width(130.dp)
                                        .height(150.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxSize() // ← важно: Column должен занять всю кнопку
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .weight(5f)
                                                .fillMaxWidth()
                                                .background(Color.Magenta),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("*IMAGE*")
                                        }
                                        Box(
                                            modifier = Modifier.weight(1f),
                                            contentAlignment = Alignment.BottomCenter
                                        ) {
                                            Text("NES")
                                        }
                                    }
                                }

                                Button(
                                    shape = RectangleShape,
                                    onClick = { },
                                    contentPadding = PaddingValues(0.dp),
                                    modifier = Modifier
                                        .padding(horizontal = 5.dp)
                                        .width(130.dp)
                                        .height(150.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxSize() // ← важно: Column должен занять всю кнопку
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .weight(5f)
                                                .fillMaxWidth()
                                                .background(Color.Magenta),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("*IMAGE*")
                                        }
                                        Box(
                                            modifier = Modifier.weight(1f),
                                            contentAlignment = Alignment.BottomCenter
                                        ) {
                                            Text("SNES")
                                        }
                                    }
                                }

                                Button(
                                    shape = RectangleShape,
                                    onClick = { },
                                    contentPadding = PaddingValues(0.dp),
                                    modifier = Modifier
                                        .padding(horizontal = 5.dp)
                                        .width(130.dp)
                                        .height(150.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxSize() // ← важно: Column должен занять всю кнопку
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .weight(5f)
                                                .fillMaxWidth()
                                                .background(Color.Magenta),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("*IMAGE*")
                                        }
                                        Box(
                                            modifier = Modifier.weight(1f),
                                            contentAlignment = Alignment.BottomCenter
                                        ) {
                                            Text("Sega MD")
                                        }
                                    }
                                }
                            }
                            Row(
                                modifier = Modifier.padding(vertical = 10.dp)
                            ) {
                                Button(
                                    shape = RectangleShape,
                                    onClick = { },
                                    contentPadding = PaddingValues(0.dp),
                                    modifier = Modifier
                                        .padding(horizontal = 5.dp)
                                        .width(130.dp)
                                        .height(150.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxSize()
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .weight(5f)
                                                .fillMaxWidth()
                                                .background(Color.Magenta),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("*IMAGE*")
                                        }
                                        Box(
                                            modifier = Modifier.weight(1f),
                                            contentAlignment = Alignment.BottomCenter
                                        ) {
                                            Text("Sony PS1")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}