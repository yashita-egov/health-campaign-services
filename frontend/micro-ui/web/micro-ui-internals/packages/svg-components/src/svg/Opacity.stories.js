import React from "react";
import { Opacity } from "./Opacity";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "Opacity",
  component: Opacity,
};

export const Default = () => <Opacity />;
export const Fill = () => <Opacity fill="blue" />;
export const Size = () => <Opacity height="50" width="50" />;
export const CustomStyle = () => <Opacity style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <Opacity className="custom-class" />;
