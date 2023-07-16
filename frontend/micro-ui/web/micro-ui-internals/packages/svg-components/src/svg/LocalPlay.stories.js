import React from "react";
import { LocalPlay } from "./LocalPlay";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "LocalPlay",
  component: LocalPlay,
};

export const Default = () => <LocalPlay />;
export const Fill = () => <LocalPlay fill="blue" />;
export const Size = () => <LocalPlay height="50" width="50" />;
export const CustomStyle = () => <LocalPlay style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <LocalPlay className="custom-class" />;
