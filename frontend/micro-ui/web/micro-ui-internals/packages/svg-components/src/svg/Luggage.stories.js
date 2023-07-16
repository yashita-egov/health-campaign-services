import React from "react";
import { Luggage } from "./Luggage";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "Luggage",
  component: Luggage,
};

export const Default = () => <Luggage />;
export const Fill = () => <Luggage fill="blue" />;
export const Size = () => <Luggage height="50" width="50" />;
export const CustomStyle = () => <Luggage style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <Luggage className="custom-class" />;
